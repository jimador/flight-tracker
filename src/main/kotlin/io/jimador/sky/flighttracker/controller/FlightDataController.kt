package io.jimador.sky.flighttracker.controller

import io.jimador.sky.flighttracker.domain.Aircraft
import io.jimador.sky.flighttracker.domain.Flight
import io.jimador.sky.flighttracker.service.FlightService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct

/**
 * @author James Dunnam
 */
@RestController
class FlightDataController(val flightService: FlightService) {

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE], value = ["/flights"])
    fun flights(): Flux<Flight> =
            Flux.from(flightService.getAllFlights())

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE], value = ["/aircraft/{icao}"])
    fun aircraft(icao: String?): Mono<Aircraft> =
        flightService.getFlightDetails(icao)
}
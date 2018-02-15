package io.jimador.sky.flighttracker.controller

import io.jimador.sky.flighttracker.service.FlightDataService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author James Dunnam
 */
@RestController
class FlightDataController(val flightDataService: FlightDataService) {

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE], value = ["/flights"])
    fun flights() = Flux.from(flightDataService.getAllFlights())

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE], value = ["/aircraft/{icao}"])
    fun aircraft(icao: String?) = flightDataService.getFlightDetails(icao)

    @GetMapping("/")
    fun home() = Mono.just("flights")

}
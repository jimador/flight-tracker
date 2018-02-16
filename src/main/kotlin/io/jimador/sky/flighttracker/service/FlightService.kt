package io.jimador.sky.flighttracker.service

import io.jimador.sky.flighttracker.domain.Aircraft
import io.jimador.sky.flighttracker.domain.Flight
import io.jimador.sky.flighttracker.repository.AircraftRepository
import io.jimador.sky.flighttracker.repository.FlightRepository
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author James Dunnam
 */
@Service
class FlightService(val aircraftRepository: AircraftRepository,
                    val flightRepository: FlightRepository) {
    val baseUrl = "https://opensky-network.org/api"
    val allStates = "/states/all"

    @Bean
    fun client(): WebClient = WebClient.create(baseUrl)

    fun getAllFlights(): Flux<Flight> = flightRepository.findAll()

    fun getFlightsFromClient(): Mono<Flight> = client().get()
            .uri(allStates)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap { it.bodyToMono(Flight::class.java) }

    fun getFlightDetails(icao24: String?): Mono<Aircraft> =
            aircraftRepository.findByIcao(icao24.orEmpty())

    @Scheduled(fixedRate = 5000)
    fun updateFlightData() {
        val data = getFlightsFromClient().block()
        if (data != null) {
            flightRepository.deleteAll()
            flightRepository.save(data)
        }
    }
}

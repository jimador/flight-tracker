package io.jimador.sky.flighttracker.service

import io.jimador.sky.flighttracker.domain.Aircraft
import io.jimador.sky.flighttracker.domain.dto.Flight
import io.jimador.sky.flighttracker.repository.FlightDataRepository
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

/**
 * @author James Dunnam
 */
@Service
class FlightDataService(val flightDataRepository: FlightDataRepository) {
    val baseUrl = "https://opensky-network.org/api"
    val allStates = "/states/all"

    @Bean
    fun client(): WebClient = WebClient.create(baseUrl)

    fun getAllFlights(): Mono<Flight> = client().get()
            .uri(allStates)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap { it.bodyToMono(Flight::class.java) }

    fun getFlightDetails(icao24: String?): Mono<Aircraft> =
            flightDataRepository.findByIcao(icao24.orEmpty())

}

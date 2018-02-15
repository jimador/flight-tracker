package io.jimador.sky.flighttracker.repository

import io.jimador.sky.flighttracker.domain.Aircraft
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

/**
 * @author James Dunnam
 */
interface FlightDataRepository : ReactiveCrudRepository<Aircraft, Long> {
    fun findByIcao(icao: String  = "") : Mono<Aircraft>
}
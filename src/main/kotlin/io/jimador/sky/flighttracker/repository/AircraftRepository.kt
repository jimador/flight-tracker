package io.jimador.sky.flighttracker.repository

import io.jimador.sky.flighttracker.domain.Aircraft
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

/**
 * @author James Dunnam
 */
@Repository
interface AircraftRepository : ReactiveCrudRepository<Aircraft, Long> {
    fun findByIcao(icao: String  = "") : Mono<Aircraft>
}
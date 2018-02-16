package io.jimador.sky.flighttracker.repository

import io.jimador.sky.flighttracker.domain.Flight
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

/**
 * @author James Dunnam
 */
@Repository
interface FlightRepository : ReactiveCrudRepository<Flight, Int>
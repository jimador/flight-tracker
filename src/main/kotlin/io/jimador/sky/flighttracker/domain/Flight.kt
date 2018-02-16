package io.jimador.sky.flighttracker.domain

import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author James Dunnam
 */
@Document(collection = "flight")
data class Flight(val time: Int , val states: List<StateVector>)
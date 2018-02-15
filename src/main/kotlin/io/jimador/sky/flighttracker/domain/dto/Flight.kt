package io.jimador.sky.flighttracker.domain.dto

/**
 * @author James Dunnam
 */
data class Flight(val time: Int , val states: List<StateVector>)
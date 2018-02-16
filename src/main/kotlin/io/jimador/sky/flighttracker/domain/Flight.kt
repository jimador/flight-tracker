package io.jimador.sky.flighttracker.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author James Dunnam
 */
@Document
data class Flight(@Id val time: Int,
                  val states: List<StateVector>)
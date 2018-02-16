package io.jimador.sky.flighttracker.domain

import com.fasterxml.jackson.annotation.JsonFormat
import io.jimador.sky.flighttracker.domain.enumeration.PositionSource


/**
 * @author James Dunnam
 */
@JsonFormat(shape= JsonFormat.Shape.ARRAY)
data class StateVector(val icao24: String?,
                       val callsign: String?,
                       val originCountry: String?,
                       val lastPositionUpdate: Double?,
                       val lastContact: Double?,
                       val longitude: Double?,
                       val latitude: Double?,
                       val geoAltitude: Double?,
                       val onGround: Boolean?,
                       val velocity: Double?,
                       val heading: Double?,
                       val verticalRate: Double?,
                       val serials: Set<Int>?,
                       val baroAltitude: Double?,
                       val squawk: String?,
                       val spi: Boolean = false,
                       val positionSource: PositionSource?)


package io.jimador.sky.flighttracker.domain.enumeration

import com.fasterxml.jackson.annotation.JsonValue

/**
 * @author James Dunnam
 */
enum class PositionSource(@JsonValue val number: Number) {
    ADS_B(0),
    ASTERIX(1),
    MLAT(2),
    OTHER( 3),

}
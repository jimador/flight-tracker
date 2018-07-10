package io.jimador.sky.flighttracker.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author James Dunnam
 */
@Document
data class Aircraft(@Id var icao: String?,
                    var registration: String?,
                    var manufacturericao: String?,
                    var manufacturername: String?,
                    var model: String?,
                    var owner: String?,
                    var operator: String?,
                    var reguntil: String?,
                    var engines: String?,
                    var built: String?)
package io.jimador.sky.flighttracker.domain

import lombok.AllArgsConstructor
import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author James Dunnam
 */
@Data
@AllArgsConstructor
@Document(collection = "aircraft")
data class Aircraft(@Id val icao: String?,
                    var registration: String?,
                    var manufacturericao: String?,
                    var manufacturername: String?,
                    var model: String?,
                    var owner: String?,
                    var operator: String?,
                    var reguntil: String?,
                    var engines: String?,
                    var built: String?)

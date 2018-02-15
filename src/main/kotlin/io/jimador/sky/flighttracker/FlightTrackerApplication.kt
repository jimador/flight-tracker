package io.jimador.sky.flighttracker

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

@SpringBootApplication
class FlightTrackerApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val profile = Optional.ofNullable(System.getProperty("environment")).orElse("default")
            val springApplication = SpringApplication(FlightTrackerApplication::class.java)
            springApplication.setAdditionalProfiles(profile)
            springApplication.run(*args)
        }
    }
}

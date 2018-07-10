package io.jimador.sky.flighttracker.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

/**
 * @author James Dunnam
 */
@EnableReactiveMongoRepositories
class MongoConfiguration : AbstractReactiveMongoConfiguration() {
    @Bean
    override fun reactiveMongoClient(): MongoClient = MongoClients.create()

    override fun getDatabaseName(): String = "aircraft-db"
}
package com.rafaelroman.tddkatasetup.fixtures

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@ContextConfiguration(initializers = [PostgresTestContainerInitializer::class])
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class WithPostgreSql


private const val POSTGRESQL_IMAGE_NAME = "postgres:14.4"

@Order(Ordered.HIGHEST_PRECEDENCE)
class PostgresTestContainerInitializer private constructor() :
    ApplicationContextInitializer<ConfigurableApplicationContext>,
    PostgreSQLContainer<PostgresTestContainerInitializer>(
        DockerImageName.parse(POSTGRESQL_IMAGE_NAME).asCompatibleSubstituteFor("postgres"),
    ) {
    companion object {
        val instance: PostgresTestContainerInitializer =
            PostgresTestContainerInitializer()
                .withDatabaseName("dbname")
                .withUsername("username")
                .withPassword("secret")
    }

    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
        println("=========DB STARTING ========")
        instance.start()
        println("=========DB STARTED ========")
        TestPropertyValues.of(
            "spring.datasource.url=${instance.jdbcUrl}",
            "spring.datasource.username=${instance.username}",
            "spring.datasource.password=${instance.password}",
        ).applyTo(configurableApplicationContext)
    }
}
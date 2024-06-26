package com.rafaelroman.tddkatasetup

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource



@Import(TestcontainersConfiguration::class)
@SpringBootTest
@WithPostgreSql
class TddKataSetupApplicationTests {

    @Test
    fun contextLoads() {
    }

    companion object{
    @DynamicPropertySource
    @JvmStatic
    fun configureProperties(registry: DynamicPropertyRegistry) {
        registry.add("spring.datasource.url") { PostgresTestContainerInitializer.instance.jdbcUrl }
        registry.add("spring.datasource.username") { PostgresTestContainerInitializer.instance.username }
        registry.add("spring.datasource.password") { PostgresTestContainerInitializer.instance.password }
    }
    }

}

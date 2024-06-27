package com.rafaelroman.tddkatasetup

import com.rafaelroman.tddkatasetup.fixtures.WithPostgreSql
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@WithPostgreSql
class TddKataSetupApplicationTests {
    @Test
    fun contextLoads() {
    }
}

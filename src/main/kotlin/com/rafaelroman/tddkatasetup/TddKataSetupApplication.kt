package com.rafaelroman.tddkatasetup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TddKataSetupApplication

fun main(args: Array<String>) {
    runApplication<TddKataSetupApplication>(*args)
}

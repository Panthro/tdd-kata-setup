package com.rafaelroman.tddkatasetup

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<TddKataSetupApplication>().with(TestcontainersConfiguration::class).run(*args)
}

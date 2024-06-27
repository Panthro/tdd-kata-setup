package com.rafaelroman.tddkatasetup.architecture

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import com.lemonappdev.konsist.api.verify.assertFalse
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test

class ArchitectureTest {
    private val rootPackage = "com.rafaelroman.tddkatasetup.notes"

    @Test
    fun `clean architecture layers have correct dependencies`() {
        Konsist
            .scopeFromProduction()
            .assertArchitecture {
                val domain = Layer("Domain", "$rootPackage.domain..")
                val application = Layer("Application", "$rootPackage.application..")
                val infrastructure = Layer("Infrastructure", "$rootPackage.infrastructure..")

                domain.dependsOnNothing()
                application.dependsOn(domain)
                infrastructure.dependsOn(domain, application)
            }
    }

    @Test
    fun `junit 4 is not allowed`() {
        Konsist
            .scopeFromTest()
            .files
            .assertFalse { it.hasImport { import -> import.name == "org.junit.Test" } }
    }

    @Test
    fun `domain should only use core language`() {
        Konsist.scopeFromPackage("$rootPackage.domain..", sourceSetName = "main")
            .imports
            .assertTrue {
                it.hasNameStartingWith("java.") ||
                    it.hasNameStartingWith("kotlin.")
            }
    }
}

package com.rafaelroman.tddkatasetup

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.support.DatabaseStartupValidator
import javax.sql.DataSource


@SpringBootApplication
class TddKataSetupApplication {

    @Bean
    fun databaseStartupValidator(dataSource: DataSource) =
        DatabaseStartupValidator().apply { setDataSource(dataSource) }

    @Bean
    fun dependsOnPostProcessor() = BeanFactoryPostProcessor { bf: ConfigurableListableBeanFactory ->
        bf.getBeanNamesForType(Flyway::class.java)
            .map { bf.getBeanDefinition(it) }
            .forEach {
                it.setDependsOn(bf.getBeanNamesForType(DatabaseStartupValidator::class.java).first())
            }
    }
}

fun main(args: Array<String>) {
    runApplication<TddKataSetupApplication>(*args)
}

package com.rafaelroman.tddkatasetup.notes.infrastructure.db

import com.rafaelroman.tddkatasetup.fixtures.WithPostgreSql
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils
import java.util.UUID

@WithPostgreSql
@SpringBootTest
class JDBCNoteRepositoryTest {
    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    @Autowired
    private lateinit var repository: JDBCNoteRepository

    @Test
    fun `should archive a note and return true`() {
        // Given
        val id = UUID.randomUUID()

        val title = RandomStringUtils.randomAlphabetic(10)
        val content = RandomStringUtils.randomAlphabetic(50)
        jdbcTemplate.update(
            """
            Insert into notes 
            ( id, title, content) 
            values (:id,:title, :content)
            """.trimIndent(),
            mapOf("id" to id, "title" to title, "content" to content),
        )

        // When

        val result = repository.archive(id)

        // Then
        result shouldBe true

        val isArchived =
            jdbcTemplate.queryForObject(
                """
                select archived from notes where id=:id
                """.trimIndent(),
                mapOf("id" to id),
                Boolean::class.java,
            )

        isArchived shouldBe true
    }

    @Test
    fun `should return false if a note does not exist`() {
        // Given
        val id = UUID.randomUUID()

        // When
        val result = repository.archive(id)

        // Then
        result shouldBe false

        assertThrows<EmptyResultDataAccessException> {
            jdbcTemplate.queryForObject(
                "select archived from notes where id=:id",
                mapOf("id" to id),
                Boolean::class.java,
            )
        }
    }
}

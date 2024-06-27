package com.rafaelroman.tddkatasetup.notes.infrastructure.http

import com.ninjasquad.springmockk.MockkBean
import com.rafaelroman.tddkatasetup.fixtures.WithPostgreSql
import com.rafaelroman.tddkatasetup.notes.application.ArchiveNoteUseCase
import com.rafaelroman.tddkatasetup.notes.application.ArchiveNoteUseCase.Response
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.put
import java.util.UUID

@WithPostgreSql
@SpringBootTest
@AutoConfigureMockMvc
class NotesControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var archiveNoteUseCase: ArchiveNoteUseCase

    @Test
    fun `should return 200 when successfully archiving a note`() {
        // Given

        val id = UUID.randomUUID()

        every { archiveNoteUseCase.execute(ArchiveNoteUseCase.Request(id)) } returns Response.Archived
        // When

        mockMvc.put("/v1/notes/$id/archive")
            .andExpect {
                // Then
                status { isOk() }
            }
    }

    @Test
    fun `should return 404 when unsuccessfully archiving a note`() {
        // Given

        val id = UUID.randomUUID()

        every { archiveNoteUseCase.execute(ArchiveNoteUseCase.Request(id)) } returns Response.NotFound
        // When

        mockMvc.put("/v1/notes/$id/archive")
            .andExpect {
                // Then
                status { isNotFound() }
            }
    }
}

package com.rafaelroman.tddkatasetup.notes.application

import com.rafaelroman.tddkatasetup.notes.domain.NoteRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.util.UUID

class ArchiveNoteUseCaseTest {

    private val repository: NoteRepository = mockk()

    private val useCase = ArchiveNoteUseCase(repository)

    @Test
    fun `should archive a note`() {
        // Given
        val id = UUID.randomUUID()

        every { repository.archive(id = id) } returns true

        // When
        val result = useCase execute ArchiveNoteUseCase.Request(id = id)

        // Then
        result shouldBe ArchiveNoteUseCase.Response.Archived
    }

    @Test
    fun `should return not found when note is not found`() {
        // Given
        val id = UUID.randomUUID()

        every { repository.archive(id = id) } returns false

        // When
        val result = useCase execute ArchiveNoteUseCase.Request(id = id)

        // Then
        result shouldBe ArchiveNoteUseCase.Response.NotFound
    }
}

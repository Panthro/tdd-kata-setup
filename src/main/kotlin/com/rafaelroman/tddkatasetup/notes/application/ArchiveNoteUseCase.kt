package com.rafaelroman.tddkatasetup.notes.application

import com.rafaelroman.tddkatasetup.notes.domain.NoteRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ArchiveNoteUseCase(private val repository: NoteRepository) {
    infix fun execute(request: Request): Response =
        if (repository.archive(request.id)) {
            Response.Archived
        } else {
            Response.NotFound
        }

    data class Request(val id: UUID)

    sealed interface Response {
        data object Archived : Response

        data object NotFound : Response
    }
}

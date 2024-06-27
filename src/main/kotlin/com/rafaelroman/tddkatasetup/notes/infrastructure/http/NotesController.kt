package com.rafaelroman.tddkatasetup.notes.infrastructure.http

import com.rafaelroman.tddkatasetup.notes.application.ArchiveNoteUseCase
import com.rafaelroman.tddkatasetup.notes.application.ArchiveNoteUseCase.Response
import com.rafaelroman.tddkatasetup.notes.domain.Note
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class NotesController(
    private val archiveNoteUseCase: ArchiveNoteUseCase,
) {
    @PostMapping("/v1/notes")
    fun createNote(
        @RequestBody note: Note,
    ): ResponseEntity<*> = TODO()

    @PutMapping("/v1/notes/{id}")
    fun updateNote(
        @PathVariable id: UUID,
        @RequestBody note: Note,
    ): ResponseEntity<*> = TODO()

    @GetMapping("/v1/notes/{id}")
    fun getNoteById(
        @PathVariable id: UUID,
    ): ResponseEntity<*> = TODO()

    @GetMapping("/v1/notes")
    fun listNotes(): ResponseEntity<*> = TODO()

    @PutMapping("/v1/notes/{id}/archive")
    fun archiveNote(
        @PathVariable id: UUID,
    ): ResponseEntity<*> =
        (archiveNoteUseCase execute ArchiveNoteUseCase.Request(id)).let {
            when (it) {
                Response.Archived -> ResponseEntity.ok().build<Unit>()
                Response.NotFound -> ResponseEntity.notFound().build()
            }
        }
}

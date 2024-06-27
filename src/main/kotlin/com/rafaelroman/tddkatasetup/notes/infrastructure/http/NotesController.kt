package com.rafaelroman.tddkatasetup.notes.infrastructure.http

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
class NotesController {

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
}

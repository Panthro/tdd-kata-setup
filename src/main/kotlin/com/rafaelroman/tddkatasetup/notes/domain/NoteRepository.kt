package com.rafaelroman.tddkatasetup.notes.domain

import java.util.UUID

interface NoteRepository {

    fun save(note: Note): SaveResponse

    fun update(note: Note): UpdateResponse

    fun delete(note: Note): DeletedResponse

    fun list(): ListResponse

    sealed interface SaveResponse {
        data class Saved(val note: Note) : SaveResponse
        data class NoteAlreadyCreated(val id: UUID) : SaveResponse
    }

    sealed interface UpdateResponse {
        data class Updated(val note: Note) : UpdateResponse
        data class NotFound(val id: UUID) : UpdateResponse
    }

    sealed interface DeletedResponse {
        data object Deleted : DeletedResponse
        data class NotFound(val id: UUID) : DeletedResponse
    }

    sealed interface ListResponse {
        data class Found(val notes: List<Note>)
    }
}

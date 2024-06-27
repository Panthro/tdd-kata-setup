package com.rafaelroman.tddkatasetup.notes.infrastructure.db

import com.rafaelroman.tddkatasetup.notes.domain.Note
import com.rafaelroman.tddkatasetup.notes.domain.NoteRepository

class JDBCNoteRepository : NoteRepository {
    override fun save(note: Note): NoteRepository.SaveResponse = TODO()

    override fun update(note: Note): NoteRepository.UpdateResponse = TODO()

    override fun delete(note: Note): NoteRepository.DeletedResponse = TODO()

    override fun list(): NoteRepository.ListResponse = TODO()
}

package com.rafaelroman.tddkatasetup.notes.infrastructure.db

import com.rafaelroman.tddkatasetup.notes.domain.Note
import com.rafaelroman.tddkatasetup.notes.domain.NoteRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class JDBCNoteRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
) : NoteRepository {
    override fun save(note: Note): NoteRepository.SaveResponse = TODO()

    override fun update(note: Note): NoteRepository.UpdateResponse = TODO()

    override fun delete(note: Note): NoteRepository.DeletedResponse = TODO()

    override fun list(): NoteRepository.ListResponse = TODO()

    override fun archive(id: UUID): Boolean =
        jdbcTemplate.update(
            "update notes set archived=true where id=:id",
            mapOf("id" to id),
        ) > 0
}

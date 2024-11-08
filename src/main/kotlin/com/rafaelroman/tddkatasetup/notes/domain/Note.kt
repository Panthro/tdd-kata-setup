package com.rafaelroman.tddkatasetup.notes.domain

import java.util.UUID

data class Note(
    val id: UUID,
    val title: String,
    val content: String,
)

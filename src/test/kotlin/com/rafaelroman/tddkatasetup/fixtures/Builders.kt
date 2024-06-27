package com.rafaelroman.tddkatasetup.fixtures

import com.rafaelroman.tddkatasetup.notes.domain.Note
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils
import java.util.UUID

fun buildNote(
    id: UUID = UUID.randomUUID(),
    title: String = RandomStringUtils.randomAlphabetic(10),
    content: String = RandomStringUtils.randomAlphabetic(100),
): Note =
    Note(
        id = id,
        title = title,
        content = content,
    )

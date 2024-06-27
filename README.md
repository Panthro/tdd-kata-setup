# Note-Taking API Kata

Welcome to the Note-Taking API Kata! This repository contains the skeleton of a simple note-taking application built with Kotlin, Spring Boot, and PostgreSQL. The purpose of this kata is to practice Test-Driven Development (TDD) by implementing features in a structured, incremental manner.

## Table of Contents

1. [Introduction](#introduction)
2. [Package Structure](#package-structure)
3. [Setting Up](#setting-up)
4. [The Kata](#the-kata)
5. [Strategies for TDD](#strategies-for-tdd)
6. [Requirements](#requirements)
7. [Running the Application](#running-the-application)
8. [Running Tests](#running-tests)

## Introduction

A kata is a small coding exercise designed to improve your skills through practice and repetition. In this kata, you'll be implementing various features for a note-taking API. You will practice TDD by writing tests before implementing the actual functionality.

## Package Structure

Here's an overview of the project's package structure:

```shell
├── HELP.md
├── README.md
├── build.gradle.kts
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
└── src
    ├── main
    │   ├── kotlin
    │   │   └── com
    │   │       └── rafaelroman
    │   │           └── tddkatasetup
    │   │               ├── TddKataSetupApplication.kt
    │   │               └── notes
    │   │                   ├── application
    │   │                   │   ├── CreateNoteUseCase.kt
    │   │                   │   ├── DeleteNoteUseCase.kt
    │   │                   │   ├── FindNoteByIdUseCase.java
    │   │                   │   ├── ListNotesUseCase.kt
    │   │                   │   └── UpdateNoteUseCase.kt
    │   │                   ├── domain
    │   │                   │   ├── Note.kt
    │   │                   │   └── NoteRepository.kt
    │   │                   └── infrastructure
    │   │                       ├── db
    │   │                       │   └── JDBCNoteRepository.kt
    │   │                       └── http
    │   │                           └── NotesController.kt
    │   └── resources
    │       ├── application.properties
    │       ├── db
    │       │   └── migration
    │       │       └── V0001__create_notes_table.sql
    │       ├── static
    │       └── templates
    └── test
        └── kotlin
            └── com
                └── rafaelroman
                    └── tddkatasetup
                        ├── TddKataSetupApplicationTests.kt
                        ├── TestTddKataSetupApplication.kt
                        ├── TestcontainersConfiguration.kt
                        └── fixtures
                            ├── Builders.kt
                            └── TestAnnotations.kt
```


### Key Packages

- **application**: Contains the use cases for the application (e.g., CreateNoteUseCase, DeleteNoteUseCase).
- **domain**: Contains the core domain models and repository interface (e.g., Note, NoteRepository).
- **infrastructure**: Contains the implementations for data persistence and web interfaces (e.g., JDBCNoteRepository, NotesController).
- **resources**: Contains configuration files and database migration scripts.
- **test**: Contains unit and integration tests.

## Setting Up

### Prerequisites

To run this project, you need the following software installed on your machine:

- [JDK 11+](https://openjdk.java.net/)
- [Docker](https://www.docker.com/)


## The Kata

### Your Task

Implement the note-taking API with the following endpoints:

- `POST /v1/notes` - Create a new note.
- `PUT /v1/notes/{id}` - Update an existing note.
- `GET /v1/notes/{id}` - Get a note by ID.
- `GET /v1/notes` - List all notes.
- `PUT /v1/notes/{id}/archive` - Archive a note.

### Skeleton Code

The repository contains skeleton code with TODOs for each endpoint and class. Your task is to complete the implementation using TDD.

## Strategies for TDD
Here are two common strategies for TDD:

### Outside-In (London School)
- **Start with the Controller**: Write an integration test for the controller.
- **Move to the Use Cases**: Write unit tests and implement the use case classes.
- **Finish with the Repository**: Write integration tests and implement the repository.

### Inside-Out (Classicist School)
- **Start with the Domain and Application Layer**: Write unit tests for the domain models and use cases.
- **Move to the Controller**: Write integration tests for the controller.
- **Finish with the Repository**: Write integration tests and implement the repository.


Choose the strategy that you feel most comfortable with or that you want to practice.

## Requirements
Unit Tests for Domain and Application Layers:

1. Implement the domain models and use cases with thorough unit tests.
   - Ensure no exceptions are thrown from the application or domain layers.
   - Integration Tests for Web (Controller) and Repository Layers:

1. Use integration tests to verify the controller endpoints.
   - Ensure repository integration tests interact with PostgreSQL (preferably using Testcontainers).
   - Integration tests should only load the necessary parts of the application context.

## Conclusion
This kata is designed to give you hands-on experience with TDD and building a RESTful API in Kotlin with Spring Boot. Follow the steps, write tests first, and ensure that your implementation meets the requirements. Good luck, and happy coding!
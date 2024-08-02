package com.harshit.Bookstore

import com.harshit.Bookstore.domain.dto.AuthorDto
import com.harshit.Bookstore.domain.dto.AuthorSummaryDto
import com.harshit.Bookstore.domain.dto.BookSummaryDto
import com.harshit.Bookstore.domain.entities.AuthorEntity
import com.harshit.Bookstore.domain.entities.BookEntity

fun testAuthorDtoA(id : Long? = null) = AuthorDto(
        id = id,
        name = "John Doe",
        age = 30,
        description = "some-description",
        image = "some-image"
)

fun testAuthorEntityA(id : Long? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "some-description",
    image = "some-image"
)

fun testAuthorEntityB(id: Long? = null) = AuthorEntity(
    id = id,
    name = "Don joe",
    age = 35,
    description = "some-description",
    image = "some-image"
)

fun testAuthorSummaryDtoA(id: Long) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "some-description",
    image = "some-image"
)

fun testBookEntity(isbn : String, author : AuthorEntity) = BookEntity(
    isbn = isbn,
    title = "TestBookA",
    description = "It is a test book",
    image = "test-image.jpeg",
    authorEntity = author
)

fun bookSummaryDtoA(isbn : String, author : AuthorSummaryDto) = BookSummaryDto(
    isbn = isbn,
    title = "TestBookA",
    description = "It is a test book",
    image = "test-image.jpeg",
    author = author
)
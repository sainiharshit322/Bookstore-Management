package com.harshit.Bookstore.services

import com.harshit.Bookstore.domain.BookSummary
import com.harshit.Bookstore.domain.dto.BookUpdateRequestDto
import com.harshit.Bookstore.domain.entities.BookEntity

interface BookService {

    fun createBook(isbn : String, bookSummary : BookSummary) : Pair<BookEntity, Boolean>

    fun list(authorId: Long?) : List<BookEntity>

    fun get(isbn: String) : BookEntity?

    fun partialUpdate(isbn: String, bookUpdateRequest: BookUpdateRequestDto) : BookEntity

    fun delete(isbn: String)
}
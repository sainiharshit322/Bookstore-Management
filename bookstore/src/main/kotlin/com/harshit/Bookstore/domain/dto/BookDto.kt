package com.harshit.Bookstore.domain.dto

class BookDto(

    val isbn: String,

    val title: String,

    val description: String,

    val image: String,

    val author: AuthorDto
)
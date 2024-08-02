package com.harshit.Bookstore.services

import com.harshit.Bookstore.domain.AuthorUpdateRequest
import com.harshit.Bookstore.domain.entities.AuthorEntity

interface AuthorService {

    fun create(authorEntity: AuthorEntity) : AuthorEntity

    fun list() : List<AuthorEntity>

    fun get(id : Long): AuthorEntity?

    fun fullUpdate(id : Long, authorEntity: AuthorEntity) : AuthorEntity

    fun partialUpdate(id: Long, authorDto: AuthorUpdateRequest) : AuthorEntity

    fun delete(id : Long)
}
package com.harshit.Bookstore.controllers

import com.harshit.Bookstore.domain.dto.AuthorDto
import com.harshit.Bookstore.domain.dto.AuthorUpdateRequestDto
import com.harshit.Bookstore.services.AuthorService
import com.harshit.Bookstore.toAuthorDto
import com.harshit.Bookstore.toAuthorEntity
import com.harshit.Bookstore.toAuthorUpdateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/v1/authors"])
class AuthorController(private val authorService: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody authorDto: AuthorDto) : ResponseEntity<AuthorDto>{
        try {
            val createdAuthor = authorService.create(
                authorDto.toAuthorEntity()
            ).toAuthorDto()
            return ResponseEntity(createdAuthor, HttpStatus.CREATED)
        } catch (ex : IllegalArgumentException){
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun readManyAuthors() : List<AuthorDto> {
        return authorService.list().map { it.toAuthorDto() }
    }

    @GetMapping(path = ["/{id}"])
    fun readOneAuthor(@PathVariable("id") id: Long): ResponseEntity<AuthorDto> {
        val foundAuthor = authorService.get(id)?.toAuthorDto()
        return foundAuthor?.let {
            ResponseEntity(it, HttpStatus.OK)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping(path = ["/{id}"])
    fun fullUpdateAuthor(@PathVariable("id") id : Long, @RequestBody authorDto: AuthorDto) : ResponseEntity<AuthorDto>{
        return try {
            val updatedAuthor = authorService.fullUpdate(id, authorDto.toAuthorEntity())
            ResponseEntity(updatedAuthor.toAuthorDto(), HttpStatus.OK)
        } catch (ex : IllegalArgumentException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PatchMapping(path = ["/{id}"])
    fun partialUpdateAuthor(@PathVariable("id") id: Long, @RequestBody authorUpdateRequest: AuthorUpdateRequestDto) : ResponseEntity<AuthorDto>{
        return try {
            val updatedAuthor = authorService.partialUpdate(id, authorUpdateRequest.toAuthorUpdateRequest())
            ResponseEntity(updatedAuthor.toAuthorDto(), HttpStatus.OK)
        } catch (ex : IllegalArgumentException){
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteAuthor(@PathVariable("id") id: Long) : ResponseEntity<Unit> {
        authorService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
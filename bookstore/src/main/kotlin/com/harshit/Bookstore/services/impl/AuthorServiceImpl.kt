package com.harshit.Bookstore.services.impl

import com.harshit.Bookstore.domain.AuthorUpdateRequest
import com.harshit.Bookstore.domain.entities.AuthorEntity
import com.harshit.Bookstore.repositories.AuthorRepository
import com.harshit.Bookstore.services.AuthorService
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {

    override fun create(authorEntity: AuthorEntity): AuthorEntity {
        return authorRepository.save(authorEntity)
    }

    override fun list(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

    override fun get(id: Long): AuthorEntity? {
        return authorRepository.findByIdOrNull(id)
    }

    @Transactional
    override fun fullUpdate(id: Long, authorEntity: AuthorEntity): AuthorEntity {
        check(authorRepository.existsById(id))
        val normalizedAuthor = authorEntity.copy(id = id)
        return authorRepository.save(normalizedAuthor)
    }

    @Transactional
    override fun partialUpdate(id: Long, authorUpdate: AuthorUpdateRequest): AuthorEntity {
        val existingAuthor = authorRepository.findByIdOrNull(id)
        checkNotNull(existingAuthor)

        val updatedAuthor = existingAuthor.copy(
            name = authorUpdate.name ?: existingAuthor.name,
            age = authorUpdate.age ?: existingAuthor.age,
            description = authorUpdate.description ?: existingAuthor.description,
            image = authorUpdate.image ?: existingAuthor.image
        )
        authorRepository.save(updatedAuthor)
        return updatedAuthor
    }

    override fun delete(id: Long) {
        authorRepository.deleteById(id)
    }
}
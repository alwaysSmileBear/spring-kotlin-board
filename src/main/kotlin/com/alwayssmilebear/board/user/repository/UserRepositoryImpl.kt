package com.alwayssmilebear.board.user.repository

import com.alwayssmilebear.board.user.domain.User
import com.alwayssmilebear.board.user.domain.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun save(user: User): User =
        userJpaRepository.save(user)

    override fun findByUsername(username: String): User? =
        userJpaRepository.findByUsername(username)

    override fun existsByEmail(email: String): Boolean =
        userJpaRepository.existsByEmail(email)
}
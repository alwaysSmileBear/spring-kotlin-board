package com.alwayssmilebear.board.user.repository

import com.alwayssmilebear.board.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Integer> {
    fun save(user: User): User
    fun findByUsername(username: String): User?
    fun existsByEmail(email: String): Boolean
}
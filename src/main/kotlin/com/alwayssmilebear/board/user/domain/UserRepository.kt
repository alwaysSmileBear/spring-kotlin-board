package com.alwayssmilebear.board.user.domain


interface UserRepository {
    fun save(user: User): User
    fun findByUsername(userName: String): User?
    fun existsByEmail(email: String): Boolean
}
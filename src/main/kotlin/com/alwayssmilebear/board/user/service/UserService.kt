package com.alwayssmilebear.board.user.service

import com.alwayssmilebear.board.user.domain.User
import com.alwayssmilebear.board.user.domain.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository
){
    @Transactional
    fun register(user: User) : User {
        if (userRepository.existsByEmail(user.email)) {
            throw IllegalArgumentException("사용중인 이메일입니다.")
        }
        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun findByUsername(username: String) : User? {
        return userRepository.findByUsername(username)
    }
}
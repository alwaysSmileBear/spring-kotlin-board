package com.alwayssmilebear.board.user.service

import com.alwayssmilebear.board.user.domain.User
import com.alwayssmilebear.board.user.domain.UserRepository
import com.alwayssmilebear.board.user.request.UserRegisterRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository
){
    @Transactional
    fun register(userRegisterRequest: UserRegisterRequest) : User {
        if (userRepository.existsByEmail(userRegisterRequest.email)) {
            throw IllegalArgumentException("사용중인 이메일입니다.")
        }

        val user = User(
            username = userRegisterRequest.username
            , password = userRegisterRequest.password
            , email = userRegisterRequest.email
        )

        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun findByUsername(username: String) : User? {
        return userRepository.findByUsername(username)
    }
}
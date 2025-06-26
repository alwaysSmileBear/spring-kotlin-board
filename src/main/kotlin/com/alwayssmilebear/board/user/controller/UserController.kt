package com.alwayssmilebear.board.user.controller

import com.alwayssmilebear.board.user.domain.User
import com.alwayssmilebear.board.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

import mu.KotlinLogging
@RestController
@RequestMapping("/api/users")
class UserController (
    private val userService: UserService

) {
    private val log = KotlinLogging.logger {}

    @PostMapping
    fun register(@RequestBody user: User): ResponseEntity<User> {
        log.info {"회원가입정보: $user"}

        val savedUser = userService.register(user)
        return ResponseEntity.ok(savedUser)
    }

    @GetMapping("/{username}")
    fun getUser(@PathVariable username: String): ResponseEntity<User> {
        val user = userService.findByUsername(username)
            ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(user)
    }
}
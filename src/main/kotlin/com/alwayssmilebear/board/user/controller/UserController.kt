package com.alwayssmilebear.board.user.controller

import com.alwayssmilebear.board.user.domain.User
import com.alwayssmilebear.board.user.request.UserRegisterRequest
import com.alwayssmilebear.board.user.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
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

    @Operation(summary = "회원가입", description = "회원가입을 합니다.")
    @PostMapping
    fun register(@RequestBody userRegisterRequest: UserRegisterRequest): ResponseEntity<User> {
        log.info {"회원가입정보: $userRegisterRequest"}

        val savedUser = userService.register(userRegisterRequest)
        return ResponseEntity.ok(savedUser)
    }
    @Operation(summary = "유저조회", description = "이름으로 유저정보를 조회한다.")
    @GetMapping("/{username}")
    fun getUser(
        @Parameter(description = "조회할 유저의 이름", example="홍길동")
        @PathVariable username: String
    ): ResponseEntity<User> {
        log.info("유저조회 : $username")
        val user = userService.findByUsername(username)
            ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(user)
    }
}
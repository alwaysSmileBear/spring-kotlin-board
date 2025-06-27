package com.alwayssmilebear.board.user.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "회원가입 요청 DTO")
data class UserRegisterRequest (
    @field:Schema(description = "사용자이름", example ="홍길동")
    val username: String,

    @field:Schema(description = "비밀번호", example ="josun")
    val password: String,

    @field:Schema(description = "이메일", example ="gildong@gmail.com")
    val email: String
)
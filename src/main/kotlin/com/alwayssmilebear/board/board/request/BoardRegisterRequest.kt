package com.alwayssmilebear.board.board.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "게시판 글등록 Request")
class BoardRegisterRequest (
    @field:Schema(description = "제목", example = "테스트글")
    val title: String,
    @field:Schema(description = "내용", example = "테스트 내용입니다.")
    val content: String
)
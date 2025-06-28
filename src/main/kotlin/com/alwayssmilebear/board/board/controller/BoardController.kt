package com.alwayssmilebear.board.board.controller

import com.alwayssmilebear.board.board.domain.Board
import com.alwayssmilebear.board.board.request.BoardRegisterRequest
import com.alwayssmilebear.board.board.service.BoardSerivce
import io.swagger.v3.oas.annotations.Operation
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/boards")
class BoardController (
    private val boardService: BoardSerivce
){
    private val log = KotlinLogging.logger {}


    @Operation(summary = "게시물등록", description = "게시물을 등록합니다.")
    @PostMapping
    fun register(@RequestBody boardRegisterRequest: BoardRegisterRequest) {
        log.info {"게시글 등록 정보: $boardRegisterRequest"}

        boardService.register(boardRegisterRequest)
    }
}
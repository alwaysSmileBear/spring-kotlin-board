package com.alwayssmilebear.board.board.service

import com.alwayssmilebear.board.board.domain.Board
import com.alwayssmilebear.board.board.domain.BoardRepository
import com.alwayssmilebear.board.board.request.BoardRegisterRequest
import org.springframework.stereotype.Service

@Service
class BoardSerivce (
    private val boardRepository: BoardRepository
){
    fun register(boardRegisterRequest: BoardRegisterRequest): Board {

        val board = Board(
            title = boardRegisterRequest.title
            , content = boardRegisterRequest.content
        )

        return boardRepository.save(board)
    }
}
package com.alwayssmilebear.board.board.repository

import com.alwayssmilebear.board.board.domain.Board
import com.alwayssmilebear.board.board.domain.BoardRepository
import org.springframework.stereotype.Repository

@Repository
class BoardRepositoryImpl (
    private val boardJpaRepository: BoardJpaRepository
) : BoardRepository {
    override fun save(board: Board): Board = boardJpaRepository.save(board)
}
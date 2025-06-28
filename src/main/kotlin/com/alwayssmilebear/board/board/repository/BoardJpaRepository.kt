package com.alwayssmilebear.board.board.repository

import com.alwayssmilebear.board.board.domain.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardJpaRepository: JpaRepository<Board, Integer> {
    fun save(board: Board): Board
}
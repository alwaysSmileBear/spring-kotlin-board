package com.alwayssmilebear.board.board.domain

interface BoardRepository {
    fun save(board: Board): Board
}
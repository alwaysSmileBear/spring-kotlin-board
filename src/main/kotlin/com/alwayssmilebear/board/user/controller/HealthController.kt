package com.alwayssmilebear.board.user.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    @GetMapping("/health")
    fun health(): String {
        return "OK"
    }
}
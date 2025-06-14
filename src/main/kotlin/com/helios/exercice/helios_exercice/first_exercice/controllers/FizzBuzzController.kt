package com.helios.exercice.helios_exercice.first_exercice.controllers

import com.helios.exercice.helios_exercice.first_exercice.models.FizzBuzzStatsDTO
import com.helios.exercice.helios_exercice.first_exercice.services.FizzBuzzService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity


@RestController
@RequestMapping("/fizzbuzz")
class FizzBuzzController (private val fizzbuzzService: FizzBuzzService ) {

    @PostMapping("/replace")
    fun replaceIntToStr(
        @RequestParam int1: Int,
        @RequestParam int2: Int,
        @RequestParam limit: Int,
        @RequestParam str1: String,
        @RequestParam str2: String
    ): ResponseEntity<List<String>> {
        return try {
            val result = fizzbuzzService.replaceIntToStr(int1= int1,int2 = int2, limit = limit, str1 =  str1, str2 =  str2)
            ResponseEntity.ok(result)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(listOf("Error: ${e.message}"))
        }
    }

    @GetMapping("/stats")
    fun getStats(): ResponseEntity<FizzBuzzStatsDTO> {
        val stats = fizzbuzzService.getMostFrequentRequest()
        return if (stats != null) {
            ResponseEntity.ok(stats)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }
}
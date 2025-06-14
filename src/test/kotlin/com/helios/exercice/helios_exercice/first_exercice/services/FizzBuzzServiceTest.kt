package com.helios.exercice.helios_exercice.first_exercice.services

import com.helios.exercice.helios_exercice.first_exercice.models.FizzBuzzRequestDTO
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FizzBuzzServiceTest {

    private val service = FizzBuzzService()

    @Test
    fun `should generate correct output`() {
        val limit = 15
        val str1 = "Fizz"
        val str2 = "Buzz"
        val result = service.replaceIntToStr(int1 = 3, int2 = 5, limit = limit, str1 = str1, str2 = str2)

        assertEquals(limit, result.size)
        assertEquals("1", result[0])
        assertEquals("2", result[1])
        assertEquals(str1, result[2])
        assertEquals("4", result[3])
        assertEquals(str2, result[4])
        assertEquals(str1 + str2, result[14])
    }

    @Test
    fun `should track requests and return the most frequent one`() {
        val req1 = FizzBuzzRequestDTO(int1 = 3, int2 = 5, limit = 15, str1 = "Fizz", str2 = "Buzz")
        val req2 = FizzBuzzRequestDTO(int1 = 2, int2 = 4, limit = 10, str1 = "Fizz", str2 = "Buzz")
        val repeatedTime = 3
        repeat(repeatedTime) {
            service.replaceIntToStr(int1 = req1.int1, int2 = req1.int2, limit = req1.limit, str1 = req1.str1, str2 = req1.str2)
        }
        service.replaceIntToStr(int1 = req2.int1, int2 = req2.int2, limit = req2.limit, str1 = req2.str1, str2 = req2.str2)

        val stats = service.getMostFrequentRequest()
        assertNotNull(stats)
        assertEquals(req1.int1, stats?.int1)
        assertEquals(req1.int2, stats?.int2)
        assertEquals(req1.limit, stats?.limit)
        assertEquals(req1.str1, stats?.str1)
        assertEquals(req1.str2, stats?.str2)
        assertEquals(repeatedTime, stats?.count)
    }

    @Test
    fun `should return null when no stats available`() {
        val newService = FizzBuzzService()
        val result = newService.getMostFrequentRequest()
        assertNull(result)
    }
}

package com.helios.exercice.helios_exercice.first_exercice.services

import com.helios.exercice.helios_exercice.first_exercice.models.FizzBuzzRequestDTO
import com.helios.exercice.helios_exercice.first_exercice.models.FizzBuzzStatsDTO
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class FizzBuzzService {

    private val stats = ConcurrentHashMap<FizzBuzzRequestDTO, Int>()

    fun replaceIntToStr(int1: Int, int2: Int, limit: Int, str1: String, str2: String): MutableList<String> {
        val listIteration = mutableListOf<String>()
        for (i in 1..limit) {
            var result = ""
            if (i % int1 == 0) result += str1
            if (i % int2 == 0) result += str2

            listIteration.add(result.ifEmpty { i.toString() })
        }

        this.getStats(FizzBuzzRequestDTO(int1 = int1, int2 = int2, limit = limit, str1 =  str1, str2 =  str2))

        return listIteration
    }
    fun getStats(req: FizzBuzzRequestDTO) {
        stats.merge(req, 1) { oldCount, newCount -> oldCount + newCount }
    }

    fun getMostFrequentRequest(): FizzBuzzStatsDTO? {
        if (stats.isEmpty()) return null
        val (request, count) = stats.maxByOrNull { it.value } ?: return null
        return FizzBuzzStatsDTO(
            int1 = request.int1,
            int2 = request.int2,
            limit = request.limit,
            str1 = request.str1,
            str2 = request.str2,
            count = count
        )
    }
}
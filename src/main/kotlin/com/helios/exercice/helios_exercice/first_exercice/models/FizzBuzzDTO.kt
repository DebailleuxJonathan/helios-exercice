package com.helios.exercice.helios_exercice.first_exercice.models

import org.springframework.validation.annotation.Validated

@Validated
data class FizzBuzzRequestDTO(
    val int1: Int,
    val int2: Int,
    val limit: Int,
    val str1: String,
    val str2: String
)

@Validated
data class FizzBuzzStatsDTO(
    val int1: Int,
    val int2: Int,
    val limit: Int,
    val str1: String,
    val str2: String,
    val count: Int
)

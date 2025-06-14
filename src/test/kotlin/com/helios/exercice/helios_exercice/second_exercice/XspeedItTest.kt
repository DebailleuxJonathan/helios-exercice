package com.helios.exercice.helios_exercice.second_exercice

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class XspeedItTest() {

    private val xspeedIt = XspeedIt()

    @Test
    fun `test return result`() {
        val strChain = "163841689525773"
        val expectedOutput = "163/81/46/82/9/55/73/7"
        val result = xspeedIt.boxesPacking(strChain)
        assertEquals(expectedOutput, result)
    }
}
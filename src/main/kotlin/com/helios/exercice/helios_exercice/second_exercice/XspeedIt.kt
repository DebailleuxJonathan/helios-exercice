package com.helios.exercice.helios_exercice.second_exercice

fun main() {
    val xspeedIt = XspeedIt()
    val strChain = "163841689525773"
    val result = xspeedIt.boxesPacking(strChain)
    println("Articles : $strChain")
    println("Cartons emballées : $result")
}

class XspeedIt {
    fun boxesPacking(strChain: String): String {
        val listBoxes = mutableListOf<MutableList<Int>>()

        for (str in strChain) {
            val strItem = str.toString().toInt()
            var isStrItemPlaced = false

            for (box in listBoxes) {
                if (box.sum() + strItem <= 10) {
                    box.add(strItem)
                    isStrItemPlaced = true
                    break
                }

            }

            if(!isStrItemPlaced) {
                listBoxes.add(mutableListOf(strItem))
            }
        }

        return listBoxes.joinToString("/") { it.joinToString("") }
    }
}

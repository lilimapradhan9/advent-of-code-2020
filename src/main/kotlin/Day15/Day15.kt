package Day15

fun numberSpoken(numberList: List<Int>, limit: Int): Int {
    val numberSpokenHistory = mutableListOf<Int>()
    numberList.forEach { numberSpokenHistory.add(it) }

    for (index in (numberSpokenHistory.size - 1)..(limit - 2)) {
        val lastIndex = numberSpokenHistory.dropLast(1).lastIndexOf(numberSpokenHistory.last())

        if (lastIndex != -1)
            numberSpokenHistory.add(index - lastIndex)
        else numberSpokenHistory.add(0)
    }
    return numberSpokenHistory.last()
}

fun numberSpokenV2(numberList: List<Int>, limit: Int): Int {
    val numberSpokenHistory = mutableMapOf<Int, Int>()
    numberList.forEachIndexed { index, number -> numberSpokenHistory[number] = index }

    var lastNumber = 0

    for (index in numberSpokenHistory.size until limit - 1) {
        val currentNumber = if (numberSpokenHistory.containsKey(lastNumber))
            index - numberSpokenHistory[lastNumber]!!
        else 0
        numberSpokenHistory[lastNumber] = index
        lastNumber = currentNumber
    }
    return lastNumber
}

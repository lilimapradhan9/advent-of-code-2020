package Day15

fun numberSpoken(numberList: List<Int>, limit: Int): Int {
    val numberSpokenHistory = mutableListOf<Int>()
    numberList.forEach { numberSpokenHistory.add(it) }

    for (index in (numberSpokenHistory.size - 1)..(limit-2)) {
        val lastIndex = numberSpokenHistory.dropLast(1).lastIndexOf(numberSpokenHistory.last())

        if (lastIndex != -1)
            numberSpokenHistory.add(index - lastIndex)
        else numberSpokenHistory.add(0)
    }
    return numberSpokenHistory.last()
}



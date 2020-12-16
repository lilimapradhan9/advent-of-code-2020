package Day16

fun scanningErrorRate(testFileInput: List<String>): Int {
    var breakNumber = 0
    val allowedList = mutableSetOf<Int>()
    val unallowedList = mutableListOf<Int>()

    testFileInput.forEach {
        if (it == "") breakNumber++;
        if (breakNumber == 0) {
            val match = Regex("([a-z ]*: )([0-9]*)-([0-9]*) or ([0-9]*)-([0-9]*)").matchEntire(it)!!.groupValues
            allowedList.addAll(match[2].toInt()..match[3].toInt())
            allowedList.addAll(match[4].toInt()..match[5].toInt())
        }
        if (breakNumber == 2) {
            val match = Regex("([0-9]+)").findAll(it).map { it.groupValues[0] }.toList()
            if (!match.isNullOrEmpty()) {
                println(match)
                match.forEach {
                    val element = it.toInt()
                    if (!allowedList.contains(element)) unallowedList.add(element)
                }
            }
        }
    }
   return unallowedList.sum()
}
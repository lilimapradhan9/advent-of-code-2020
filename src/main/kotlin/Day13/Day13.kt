package Day13

fun idmultipliedBytime(testFileInput: List<String>): Int {
    var minTimeDiff = Integer.MAX_VALUE
    var busToTravel = Integer.MAX_VALUE
    val earliestTime = testFileInput.first().toInt()
    Regex("[0-9]+")
        .findAll(testFileInput[1])
        .forEach {
            val busNumber = it.groupValues[0].toInt()

            val timeDiffForCurrentBus = busNumber - (earliestTime % busNumber)
            if (timeDiffForCurrentBus < minTimeDiff) {
                minTimeDiff = timeDiffForCurrentBus
                busToTravel = busNumber
            }
        }

    return minTimeDiff * busToTravel
}
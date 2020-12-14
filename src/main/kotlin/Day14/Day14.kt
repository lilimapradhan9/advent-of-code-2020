package Day14


fun sumOfValues(inputLines: List<String>): Long {
    val memory = mutableMapOf<String, String>()
    var mask = ""
    for (line in inputLines) {
        when (line.startsWith("mask = ")) {
            true -> mask = line.split("mask = ")[1]
            else -> updateMemory(line, memory, mask)
        }
    }
    return memory.values.map { it.toLong(2) }.sum()
}

@ExperimentalStdlibApi
fun sumOfValuesForVaryingMask(inputLines: List<String>): Long {
    val memory = mutableMapOf<Long, Long>()
    var mask = ""
    for (line in inputLines) {
        when (line.startsWith("mask = ")) {
            true -> mask = line.split("mask = ")[1]
            else -> {
                val value = line.split(" = ")
                val memoryAddress = value[0]
                    .split("mem[")[1]
                    .split("]")[0]
                    .toInt()
                    .toString(2)

                val valueToBeStored = value[1].toLong()

                val maskedAddress = applyMask(mask, memoryAddress.padStart(36, '0'), '0')

                val variations: List<Long> = findPossibleAddresses(maskedAddress)
                variations.forEach {
                    memory[it] = valueToBeStored
                }
            }
        }
    }
    return memory.values.sum()
}


private fun updateMemory(
    line: String,
    memory: MutableMap<String, String>,
    mask: String
) {
    val value = line.split(" = ")
    val memoryAddress = value[0].split("mem[")[1].split("]")[0]
    val binaryRep = value[1].toInt().toString(2)
    memory[memoryAddress] = applyMask(mask, binaryRep.padStart(36, '0'), 'X')
}

private fun applyMask(mask: String, padded: String, charToReplace: Char): String {
    return mask.mapIndexed { index, char ->
        when (char == charToReplace) {
            true -> padded[index]
            else -> char
        }
    }.joinToString(separator = "")
}

@ExperimentalStdlibApi
fun findPossibleAddresses(maskedAddress: String): List<Long> {
    val addressList = mutableListOf<String>()
    addressList.add("")

    for (i in maskedAddress.indices) {
        if (maskedAddress[i] == 'X') {
            for (index in 0 until addressList.size) {
                val add = addressList.removeFirst()
                addressList += add + "0"
                addressList += add + "1"
            }
        } else {
            for (index in addressList.indices)
                addressList[index] = addressList[index] + maskedAddress[i]
        }
    }

    return addressList.map { it.toLong(2) }
}

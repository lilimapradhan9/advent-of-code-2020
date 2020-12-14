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

private fun updateMemory(
    line: String,
    memory: MutableMap<String, String>,
    mask: String
) {
    val value = line.split(" = ")
    val memoryAddress = value[0].split("mem[")[1].split("]")[0]
    val binaryRep = value[1].toInt().toString(2)
    memory[memoryAddress] = applyMask(mask, binaryRep.padStart(36, '0'))
}

private fun applyMask(mask: String, padded: String): String {
    return mask.mapIndexed { index, char ->
        when (char == 'X') {
            true -> padded[index]
            else -> char
        }
    }.joinToString(separator = "")
}

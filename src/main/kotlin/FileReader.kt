import java.io.File

fun readFile(fileName: String): List<String> {
    val input = mutableListOf<String>()
    File(fileName).forEachLine { input.add(it) }
    return input
}
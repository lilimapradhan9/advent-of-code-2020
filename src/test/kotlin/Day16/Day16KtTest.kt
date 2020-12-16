package Day16

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import readFile

class Day16KtTest {
    @Test
    fun `should return the scanning error rate for example`() {
        val testFileInput = readFile("src/test/resources/day16")

        val result = scanningErrorRate(testFileInput)

        Assertions.assertEquals(71, result)
    }

    @Test
    fun `should return the scanning error rate`() {
        val testFileInput = readFile("src/main/resources/day16")

        val result = scanningErrorRate(testFileInput)

        Assertions.assertEquals(25895, result)
    }
}
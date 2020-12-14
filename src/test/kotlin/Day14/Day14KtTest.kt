package Day14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import readFile

class Day14KtTest {
    @Test
    fun `should return sum of values for example`() {
        val testFileInput = readFile("src/test/resources/day14")

        val result = sumOfValues(testFileInput)

        assertEquals(165, result)
    }

    @Test
    fun `should return sum of values`() {
        val testFileInput = readFile("src/main/resources/day14")

        val result = sumOfValues(testFileInput)

        assertEquals(7611244640053, result)
    }
}
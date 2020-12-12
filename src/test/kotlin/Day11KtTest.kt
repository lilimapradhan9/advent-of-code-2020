import Day11.manhattanDistance
import Day11.wayPointRelativeDistance
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day11KtTest {
    @Test
    fun `should find manhattan distance for example`() {
        val testFileInput = readFile("src/test/resources/day11")

        val result = manhattanDistance(testFileInput)

        Assertions.assertEquals(25, result)
    }

    @Test
    fun `should find manhattan distance`() {
        val testFileInput = readFile("src/main/resources/day11")

        val result = manhattanDistance(testFileInput)

        Assertions.assertEquals(508, result)
    }

    @Test
    fun `should find relative waypoint distance for example`() {
        val testFileInput = readFile("src/test/resources/day11")

        val result = wayPointRelativeDistance(testFileInput)

        Assertions.assertEquals(286, result)
    }

    @Test
    fun `should find relative waypoint distance distance`() {
        val testFileInput = readFile("src/main/resources/day11")

        val result = wayPointRelativeDistance(testFileInput)

        Assertions.assertEquals(30761, result)
    }
}
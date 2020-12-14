import Day13.idmultipliedBytime
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day13KtTest {
    @Test
    fun `should find id multipled by time for example`() {
        val testFileInput = readFile("src/test/resources/day13")

        val result = idmultipliedBytime(testFileInput)

        Assertions.assertEquals(295, result)
    }

    @Test
    fun `should find manhattan distance`() {
        val testFileInput = readFile("src/main/resources/day13")

        val result = idmultipliedBytime(testFileInput)

        Assertions.assertEquals(3385, result)
    }
}
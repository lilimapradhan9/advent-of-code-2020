package Day15

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day15KtTest {
    @Test
    fun `should return the 2020 spoken number for 1,3,2`() {
        val numberSpoken = numberSpoken(listOf(0, 3, 6), 2020)

        Assertions.assertEquals(436, numberSpoken)
    }

    @Test
    fun `should return the 2020 spoken number for 0,13,1,8,6,15`() {
        val numberSpoken = numberSpoken(listOf(0, 13, 1, 8, 6, 15), 2020)

        Assertions.assertEquals(1618, numberSpoken)
    }
}
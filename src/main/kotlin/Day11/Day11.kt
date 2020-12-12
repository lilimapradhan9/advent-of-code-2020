package Day11

import kotlin.math.abs

data class Position(
    var point: Point,
    var direction: Direction
) {
    fun updatePosition(action: String, value: String) {
        when (action) {
            "E", "W", "S", "N" -> point = Direction.valueOf(action).newPos(point, value.toInt())
            "R" -> direction = direction.updateDirection(direction, value.toInt())
            "L" -> direction = direction.updateDirection(direction, -value.toInt())
            "F" -> point = direction.newPos(point, value.toInt())
        }
    }
}

val regex = Regex("([NSEWLRF])([0-9]*)")
fun manhattanDistance(input: List<String>): Int {
    val shipPosition = Position(Point(0, 0), Direction.E)

    input.forEach {
        val (_, action, value) = regex.find(it)!!.groupValues
        shipPosition.updatePosition(action, value)
        println(shipPosition)
    }

    return abs(shipPosition.point.x) + abs(shipPosition.point.y)
}

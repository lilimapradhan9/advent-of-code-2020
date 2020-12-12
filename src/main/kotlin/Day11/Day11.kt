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
    }

    return abs(shipPosition.point.x) + abs(shipPosition.point.y)
}


fun wayPointRelativeDistance(input: List<String>): Int {
    var ship = Point(0, 0)
    var wayPoint = Point(10, 1)

    input.forEach {
        val (_, action, stringValue) = regex.find(it)!!.groupValues
        val value = stringValue.toInt()
        when (action) {
            "N" -> wayPoint = Point(wayPoint.x, wayPoint.y + value)
            "S" -> wayPoint = Point(wayPoint.x, wayPoint.y - value)
            "E" -> wayPoint = Point(wayPoint.x + value, wayPoint.y)
            "W" -> wayPoint = Point(wayPoint.x - value, wayPoint.y)
            "L" -> {
                repeat(value / 90) {
                    wayPoint = Point(-wayPoint.y, wayPoint.x)
                }
            }
            "R" -> {
                repeat(value / 90) {
                    wayPoint = Point(wayPoint.y, -wayPoint.x)
                }
            }
            "F" -> {
                ship = Point(ship.x + wayPoint.x * value, ship.y + wayPoint.y * value)
            }
        }
    }

    return abs(ship.x) + abs(ship.y)
}

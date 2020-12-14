package Day12

enum class Direction {
    N {
        override fun newPos(point: Point, value: Int): Point {
            return Point(
                point.x,
                point.y + value
            )
        }

        override fun updateDirection(direction: Direction, value: Int): Direction {
            return direction(value, E, S, W)
        }
    },
    E {
        override fun newPos(point: Point, value: Int): Point {
            return Point(
                point.x + value,
                point.y
            )
        }

        override fun updateDirection(direction: Direction, value: Int): Direction {
            return direction(value, S, W, N)
        }
    },
    W {
        override fun newPos(point: Point, value: Int): Point {
            return Point(
                point.x - value,
                point.y
            )
        }

        override fun updateDirection(direction: Direction, value: Int): Direction {
            return direction(value, N, E, S)
        }
    },
    S {
        override fun newPos(point: Point, value: Int): Point {
            return Point(
                point.x,
                point.y - value
            )
        }

        override fun updateDirection(direction: Direction, value: Int): Direction {
            return direction(value, W, N, E)
        }
    };

    abstract fun newPos(point: Point, value: Int): Point
    abstract fun updateDirection(direction: Direction, value: Int): Direction

    fun direction(
        value: Int,
        dirFor1: Direction,
        dirFor2: Direction,
        dirFor3: Direction
    ): Direction {
        return when (value) {
            90 -> dirFor1
            180 -> dirFor2
            270 -> dirFor3
            -90 -> dirFor3
            -180 -> dirFor2
            -270 -> dirFor1
            else -> this
        }
    }
}
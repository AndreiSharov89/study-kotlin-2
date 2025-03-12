class Point(private val x: Int, private val y: Int) {

    // перегрузите оператор plus
    // перегрузите оператор minus
    // перегрузите оператор times
    // перегрузите оператор div

    operator fun plus(point:Point): Point{
        return Point((x+point.x), (y+point.y))
    }
    operator fun minus(point:Point): Point{
        return Point((x-point.x), (y-point.y))
    }
    operator fun times(point:Point): Point{
        return Point((x*point.x), (y*point.y))
    }
    operator fun div(point:Point): Point{
        if (point.x*point.y != 0)
        return Point((x/point.x), (y/point.y))
        else return Point(0, 0)
    }

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }
}

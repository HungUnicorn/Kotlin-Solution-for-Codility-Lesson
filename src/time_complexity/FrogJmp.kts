package time_complexity

import kotlin.math.ceil

fun solution(X: Int, Y: Int, D: Int): Int {
    if (X == Y) {
        return 0
    }
    if ( D > (Y -X)) {
        return 1
    }

    return ceil((Y - X).toDouble() / D.toDouble()).toInt()
}

check(3 == solution(10, 85, 30))

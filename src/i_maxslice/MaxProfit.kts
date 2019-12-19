package i_maxslice

import kotlin.math.max
import kotlin.math.min

fun solution(A: IntArray): Int {
    if (A.size < 2) {
        return 0
    }

    var minPrice = A[0]
    var profit = 0
    for (i in 1 until A.size) {
        profit = max(profit, A[i] - minPrice)
        minPrice = min(A[i], minPrice)

    }
    return profit
}

check(356 == solution(listOf(23171, 21011, 21123, 21366, 21013, 21367).toIntArray()))
check(0 == solution(emptyList<Int>().toIntArray()))
check(0 == solution(listOf(0, 0, 0).toIntArray()))

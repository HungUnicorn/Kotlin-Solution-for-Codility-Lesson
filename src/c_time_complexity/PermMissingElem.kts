package c_time_complexity

fun solution(A: IntArray): Int {
    val expected = (A.size.toDouble() + 1) * (A.size.toDouble() + 2) / 2
    val real = A.map { it.toDouble() }.sum()

    return (expected - real).toInt()
}

check(4 == solution(listOf(2, 3, 1, 5).toIntArray()))

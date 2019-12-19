package d_counting_elements

fun solution(A: IntArray): Int {
    if (A.distinct().size != A.size) {
        return 0
    }
    val expected = (A.size.toDouble()) * (A.size.toDouble() + 1) / 2
    val real = A.map { it.toDouble() }.sum()

    return if (expected == real) 1 else 0
}


check(0 == solution(listOf(1, 4, 1).toIntArray()))
check(0 == solution(listOf(1, 3, 1).toIntArray()))
check(1 == solution(listOf(1, 3, 2).toIntArray()))

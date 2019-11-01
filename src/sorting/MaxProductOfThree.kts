package sorting

fun solution(A: IntArray): Int {
    A.sort()

    val positiveMax = A[A.size - 3] * A[A.size - 2] * A[A.size - 1]

    if (A[1] >= 0) {
        return positiveMax
    }

    val negativeMax = A[0] * A[1] * A[A.size - 1]

    if (negativeMax > positiveMax) {
        return negativeMax
    }

    return positiveMax
}

check(60 == solution(listOf(-3, 1, 2, -2, 5, 6).toIntArray()))
check(180 == solution(listOf(-5, -6, 2, -2, 4, 6).toIntArray()))

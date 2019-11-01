package arrays

import kotlin.assert as assert1

fun solution(A: IntArray): Int {
    if (A.size == 1) {
        return A[0]
    }

    A.sort()

    for (i in 0..A.size step 2) {
        if (i == A.size - 1) {
            return A[i]
        }

        if (A[i] != A[i + 1]) {
            return A[i]
        }
    }

    return -1
}

check(1 == solution(listOf(1, 1, 2, 3, 4).toIntArray()))

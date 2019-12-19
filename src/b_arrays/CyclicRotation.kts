package b_arrays

fun solution(A: IntArray, K: Int): IntArray {
    if (A.size == 1 || A.isEmpty() || A.size == K) {
        return A
    }

    val shifts = K % A.size

    val result = IntArray(A.size)
    for (i in A.indices) {
        if (i + shifts < A.size) {
            result[i + shifts] = A[i]
        } else {
            result[i + shifts - A.size] = A[i]
        }
    }
    return result
}

check(emptyArray<Int>().toIntArray().contentEquals(solution(emptyArray<Int>().toIntArray(), 0)))
check(listOf(9, 7, 6, 3, 8).toIntArray().contentEquals(solution(listOf(3, 8, 9, 7, 6).toIntArray(), 3)))
check(listOf(1, 2, 3, 4).toIntArray().contentEquals(solution(listOf(1, 2, 3, 4).toIntArray(), 4)))
check(listOf(0, 0, 0).toIntArray().contentEquals(solution(listOf(0, 0, 0).toIntArray(), 1)))

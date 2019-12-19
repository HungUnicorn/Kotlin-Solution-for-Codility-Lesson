package d_counting_elements

fun solution(N: Int, A: IntArray): IntArray {
    val result = MutableList(N) { 0 }

    var max = 0
    var base = 0
    for (element in A) {
        if (element == N + 1) {
            base = max;
        } else {
            if (result[element - 1] < base)
                result[element - 1] = base + 1
            else
                result[element - 1]++

            if (max < result[element - 1])
                max = result[element - 1]
        }
    }

    for (i in 0 until result.size) {
        if (result[i] < base)
            result[i] = base
    }

    return result.toIntArray()
}

check(
        listOf(3, 2, 2, 4, 2).toIntArray()
                .contentEquals(
                        solution(
                                5, listOf(3, 4, 4, 6, 1, 4, 4)
                                .toIntArray()
                        )
                )
)

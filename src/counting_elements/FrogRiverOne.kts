package counting_elements


fun solution(X: Int, A: IntArray): Int {
    val shouldBeSum = X * (X + 1) / 2
    val seen = hashSetOf<Int>()

    var sum = 0
    for (elem in A.withIndex()) {
        if (!seen.contains(elem.value)) {
            sum += elem.value
            seen.add(elem.value)
            if (sum == shouldBeSum) {
                return elem.index
            }
        }
    }
    return -1
}

check(6 == solution(5, listOf(1, 3, 1, 4, 2, 3, 5, 4).toIntArray()))
check(-1 == solution(5, listOf(1, 3, 1, 4, 2, 3, 6, 4).toIntArray()))
check(-1 == solution(2, listOf(2, 2, 4).toIntArray()))


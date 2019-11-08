package leader

fun solution(A: IntArray): Int {
    val toSort = A.copyOf()
    toSort.sort()
    var leader = -1
    var count = 0

    for (elem in toSort) {
        if (elem == toSort[toSort.size / 2]) {
            count++
            leader = elem
        }
    }
    if (count > (A.size / 2).toDouble()) {
        return A.indexOf(leader)

    }
    return -1
}

check(0 == solution(listOf(6, 6, 1, 1, 6).toIntArray()))
check(-1 == solution(emptyList<Int>().toIntArray()))
check(0 == solution(listOf(1).toIntArray()))


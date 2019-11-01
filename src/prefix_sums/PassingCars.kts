package prefix_sums

val limit = 1_000_000_000

fun solution(A: IntArray): Int {
    if (A.size > 100000) {
        return -1
    }

    var sum = 0
    var numberOfOnes = 0

    for (elem in A.reversed()) {
        if (sum > limit) {
            return -1
        }

        if (elem == 1) {
            numberOfOnes += 1
        } else if (elem == 0) {
            sum += numberOfOnes
        }
    }

    return sum
}

check(5 == solution(listOf(0, 1, 0, 1, 1).toIntArray()))

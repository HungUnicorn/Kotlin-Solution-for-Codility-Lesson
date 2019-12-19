package q_greedy_algorithms

fun solution(K: Int, A: IntArray): Int {
    // write your code in Kotlin
    var sum = 0
    var count = 0

    for (item in A) {
        sum += item
        if (sum >= K) {
            count++
            sum = 0
        }
    }
    return count
}

check(3 == solution(4, listOf(1, 2, 3, 4, 1, 1, 3).toIntArray()))
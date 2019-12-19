package m_euclidean_algorithm

fun solution(N: Int, M: Int): Int {
    // write your code in Kotlin
    val gcd = gcd(N, M)
    return N / gcd
}

fun gcd(a: Int, b: Int): Int {
    if (a % b == 0) {
        return b
    }
    return gcd(b, a % b)
}

check(5 == solution(10, 4))

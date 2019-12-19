package l_sieve

import kotlin.math.pow
import kotlin.math.sqrt

fun solution(N: Int, P: IntArray, Q: IntArray): IntArray {
    if (P.size != Q.size || P.isEmpty() || Q.isEmpty()) {
        return emptyList<Int>().toIntArray()
    }

    if (N <= 3) {
        val zeros = Array(P.size) { 0 }
        return zeros.toIntArray()
    }

    val result = arrayListOf<Int>()

    val limit = getLimit(N, Q)

    val cumulativeNumSemiPrimes = getCumulativeNumSemiPrimes(limit)

    for (i in P.indices) {
        val numSemiPrimes = cumulativeNumSemiPrimes[Q[i]] - cumulativeNumSemiPrimes[P[i]-1]
        result.add(numSemiPrimes)
    }

    return result.toIntArray()
}

fun getLimit(N: Int, Q: IntArray): Int {
    var limit: Int = Q.max()!!
    if (limit > N) {
        limit = N
    }
    return limit
}

fun sieveSimple(n: Int): Array<Boolean> {
    val indices = Array(n + 1) { true }
    indices[0] = false
    indices[1] = false

    val limit = sqrt(n.toDouble()).toInt()
    val range = 2..limit
    for (i in range) {
        if (indices[i]) {
            var j = i.toDouble().pow(2).toInt()
            while (j <= n) {
                indices[j] = false
                j += i
            }
        }
    }
    return indices
}

fun getPrimes(sieved: Array<Boolean>): IntArray {
    val result = arrayListOf<Int>()
    for (i in sieved.indices) {
        if (sieved[i]) {
            result.add(i)
        }
    }
    return result.toIntArray()
}

fun getCumulativeNumSemiPrimes(n: Int): List<Int> {
    val sieved = sieveSimple(n / 2)
    val primes = getPrimes(sieved)
    val cumulativeNumSemiPrimes = Array(n + 1) { 0 }

    for (p1 in primes) {
        for (p2 in primes) {
            if (p1 * p2 > n || p2 > p1) {
                break
            }
            cumulativeNumSemiPrimes[p1 * p2] = 1
        }
    }

    for (i in 1 .. n) {
        cumulativeNumSemiPrimes[i] += cumulativeNumSemiPrimes[i - 1]
    }
    return cumulativeNumSemiPrimes.toList()
}

check(
    listOf(10, 4, 0).toIntArray().contentEquals(
        solution(
            26,
            listOf(1, 4, 16).toIntArray(),
            listOf(26, 10, 20).toIntArray()
        )
    )
)

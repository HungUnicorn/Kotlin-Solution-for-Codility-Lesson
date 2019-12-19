package a_iterations

fun solution(N: Int): Int {
    val zeroAndOnes = Integer.toBinaryString(N)
        .replace(Regex("0+$"), "")

    val zeros = zeroAndOnes.split(Regex("1+"))

    val lengths = zeros.map(String::length)
        .filter { it > 0 }

    return lengths.max()!!.or(0)
}

check(2 == solution(9913))

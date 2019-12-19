package j_primenumbers

fun solution(N: Int): Int {
    var i = 1
    var count = 0
    while (i * i < N) {
        if (N % i == 0) {
            count += 2
        }
        i++
    }
    if (i * i == N) {
        count++
    }
    return count
}

check(8 == solution(24))
check(1 == solution(1))

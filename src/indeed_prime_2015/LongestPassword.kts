package indeed_prime_2015

fun solution(S: String): Int {
    val split: List<String> = S.split(" ");
    var max = -1

    for (pw in split) {
        val toCharArray = pw.toCharArray()
        var numLetters = 0
        var numDigits = 0
        var numOthers = 0

        for (char in toCharArray) {
            when {
                char.isLetter() -> {
                    numLetters++
                }
                char.isDigit() -> {
                    numDigits++
                }
                else -> {
                    numOthers++
                }
            }
        }

        if (numOthers == 0 && numLetters % 2 == 0 && numDigits % 2 == 1) {
            if (pw.length > max) {
                max = pw.length
            }
        }
    }
    return max
}

check(-1 == solution("test"))
check(7 == solution("test 5 a0A pass007 ?xy1"))

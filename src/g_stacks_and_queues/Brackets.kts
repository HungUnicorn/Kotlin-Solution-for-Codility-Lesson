package g_stacks_and_queues

import java.util.Stack

fun solution(S: String): Int {
    val stack = Stack<Char>()

    for (letter in S) {
        if (letter == '{' || letter == '[' || letter == '(') {
            stack.push(letter)
        } else {
            // No left
            if (stack.empty()) {
                return 0
            }
            val last = stack.pop()
            if (!isValid(last, letter)) {
                return 0
            }
        }
    }

    // Some rights are not paired
    if (!stack.empty()) {
        return 0
    }

    return 1
}

fun isValid(left: Char, right: Char): Boolean {
    if (left == '{' && right == '}') {
        return true
    } else if (left == '[' && right == ']') {
        return true
    } else if (left == '(' && right == ')') {
        return true
    }
    return false
}


check(1 == solution("{[()()]}"))
check(0 == solution("([)()]"))
check(0 == solution(")("))

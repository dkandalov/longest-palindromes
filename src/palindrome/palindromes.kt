package palindrome

import kotlin.coroutines.experimental.buildSequence


data class Palindrome(val value: String, val range: IntRange) {
    override fun toString() = "Text: $value, Index: ${range.first}, Length: ${value.length}"
}

fun findLongestPalindromes(s: String, maxAmount: Int = 3, minPalindromeSize: Int = 2): List<Palindrome> {
    val result = ArrayList<Palindrome>()
    s.allSubstrings()
        .filter { it.first.length >= minPalindromeSize }
        .forEach { (substring, range) ->
            if (substring.isPalindrome() && result.none { it.range.contains(range) }) {
                result.add(Palindrome(substring, range))
            }
        }
    return result.sortedBy { -it.value.length }.distinct().take(maxAmount)
}

fun String.allSubstrings(): Sequence<Pair<String, IntRange>> = buildSequence {
    val s = this@allSubstrings
    0.until(s.length).forEach { from ->
        s.length.downTo(from + 1).forEach { to ->
            val range = IntRange(from, to - 1)
            val substring = s.substring(range)
            yield(Pair(substring, range))
        }
    }
}

tailrec fun String.isPalindrome(): Boolean =
    if (length < 2) true
    else if (first() != last()) false
    else substring(1, length - 1).isPalindrome()

private fun IntRange.contains(range: IntRange) = contains(range.first) && contains(range.last)

package palindrome

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class FindLongestPalindromesTest {

    @Test fun `example from the task`() {
        findLongestPalindromes("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop") shouldEqual listOf(
            Palindrome("hijkllkjih", IntRange(23, 32)),
            Palindrome("defggfed", IntRange(13, 20)),
            Palindrome("abccba", IntRange(5, 10))
        )
    }

    @Test fun `basic examples`() {
        findLongestPalindromes("") shouldEqual emptyList()
        findLongestPalindromes("a") shouldEqual emptyList()
        findLongestPalindromes("ab") shouldEqual emptyList()
        findLongestPalindromes("aa") shouldEqual listOf(Palindrome("aa", IntRange(0, 1)))
        findLongestPalindromes("aba") shouldEqual listOf(Palindrome("aba", IntRange(0, 2)))
        findLongestPalindromes("-aba=") shouldEqual listOf(Palindrome("aba", IntRange(1, 3)))
        findLongestPalindromes("sator square: sator arepo tenet opera rotas") shouldEqual listOf(
            Palindrome("sator arepo tenet opera rotas", IntRange(14, 42))
        )
    }

    @Test fun `overlapping palindromes`() {
        findLongestPalindromes("aabab") shouldEqual listOf(
            Palindrome("aba", IntRange(1, 3)),
            Palindrome("bab", IntRange(2, 4)),
            Palindrome("aa", IntRange(0, 1))
        )
    }
    
    @Test fun `palindromes with the same value but different ranges`() {
        findLongestPalindromes("aa|-aa") shouldEqual listOf(
            Palindrome("aa", IntRange(0, 1)),
            Palindrome("aa", IntRange(4, 5))
        )
    }

    @Test fun `palindromes with ranges including each other`() {
        // doesn't include "bcb" because it's within the range of longer palindrome
        findLongestPalindromes("abcba") shouldEqual listOf(Palindrome("abcba", IntRange(0, 4)))

        // includes "bcb" because it's outside of the range of longer palindrome
        findLongestPalindromes("abcba|bcb") shouldEqual listOf(
            Palindrome("abcba", IntRange(0, 4)),
            Palindrome("bcb", IntRange(6, 8))
        )
    }

    @Test fun `find all substrings of a string`() {
        fun String.listOfAllSubstrings() = allSubstrings().map { it.first }.toList()

        "".listOfAllSubstrings() shouldEqual emptyList()
        "a".listOfAllSubstrings() shouldEqual listOf("a")
        "ab".listOfAllSubstrings() shouldEqual listOf("ab", "a", "b")
        "abc".listOfAllSubstrings() shouldEqual listOf("abc", "ab", "a", "bc", "b", "c")
        "abcd".listOfAllSubstrings() shouldEqual listOf(
            "abcd", "abc", "ab", "a",
            "bcd", "bc", "b",
            "cd", "c",
            "d"
        )
    }
}

class PalindromeTest {
    @Test fun `determine if string is a palindrome`() {
        "".isPalindrome() shouldEqual true
        "a".isPalindrome() shouldEqual true
        "aa".isPalindrome() shouldEqual true

        "ab".isPalindrome() shouldEqual false
        "ba".isPalindrome() shouldEqual false

        "aba".isPalindrome() shouldEqual true
        "abba".isPalindrome() shouldEqual true
        "aabba".isPalindrome() shouldEqual false
    }
}

infix fun <T> T.shouldEqual(that: T) {
    assertThat(this, equalTo(that))
}

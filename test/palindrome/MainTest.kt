package palindrome

import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {
    @Test fun `no arguments`() {
        runProgram(args = emptyArray()) shouldEqual """
            |Usage: longest-palindromes <string>
            |For example:
            |> ./longest-palindromes "Sator square consists of a sentence written in Latin: 'sator arepo tenet opera rotas'"
            |
        """.trimMargin("|")
    }

    @Test fun `output for string with palindromes`() {
        runProgram(args = arrayOf("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop")) shouldEqual """
            |Text: hijkllkjih, Index: 23, Length: 10
            |
            |Text: defggfed, Index: 13, Length: 8
            |
            |Text: abccba, Index: 5, Length: 6
            |
        """.trimMargin("|")
    }

    @Test fun `output for string without any palindromes`() {
        runProgram(args = arrayOf("no-palindromes")) shouldEqual """
            |
            |
        """.trimMargin("|")
    }

    private fun runProgram(args: Array<String>): String {
        val outputStream = ByteArrayOutputStream()
        main(args, PrintStream(outputStream))
        return outputStream.toString("UTF-8")
    }
}
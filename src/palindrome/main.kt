package palindrome

import java.io.PrintStream

fun main(args: Array<String>) {
    main(args, System.out)
}

fun main(args: Array<String>, printStream: PrintStream) {
    if (args.isEmpty()) {
        printStream.println("Usage: longest-palindromes <string>")
        printStream.println("For example:\n> ./longest-palindromes \"Sator square consists of a sentence written in Latin: 'sator arepo tenet opera rotas'\"")
        return
    }
    val output = findLongestPalindromes(args[0])
        .joinToString("\n\n") { palindrome ->
            "Text: ${palindrome.value}, Index: ${palindrome.range.first}, Length: ${palindrome.value.length}"
        }
    printStream.println(output)
}

This is a command line program which finds three longest [palindromes](https://en.wikipedia.org/wiki/Palindrome) in an input string.

### How to use it?

- Build the source code using [gradle](https://gradle.org). 
  In the project directory: `./gradlew build`.
- Unpack created `tar` or `zip` archive, e.g. `tar -xzf build/distributions/longest-palindromes-0.0.tar`
- Run shell or batch script in the `bin` directory, e.g. `cd ./longest-palindromes-0.0/bin && ./longest-palindromes "hello"`


### Implementation notes

- In the task description "unique palindromes" is assumed to mean "palindromes with ranges which do not contain each other".
  This is because if "unique" is used in the common sense of "not equal to other palindromes", then example output will contain additional palindrome "ijkllkji".
       
- Unlike the output specified in the task, actual output has a trailing newline
  (because some terminals will not add newline after program termination and will expect user input on the same line).

- Single characters are not included in the list of longest palindromes (even though they are technically palindromes)
  because arguably this is not a very interesting output for users.

- Some palindromes examples ignore whitespace and punctuation characters. 
  This program interprets input as it is (because it wasn't required in the task and to keep implementation simple). 

- Since the task description doesn't quantify the meaning of "efficient" (e.g. in terms of input string size and maximum execution time), 
  no particular optimisations were done assuming that in the real world it will be possible to clarify use-cases / requirements.

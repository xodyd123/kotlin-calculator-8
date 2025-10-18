package calculator

class Calculator {
    private val delimiters = arrayOf(",", ":")
    fun circulate(inputUser: String): Int {
        var sum = 0
        if (inputUser.isEmpty()) return 0
        val splitInput = checkCustomDelimiter(inputUser)
        circulateValidator(splitInput)
        for (string in splitInput) {
            sum += string.toInt()
        }
        return sum
    }

    private fun checkCustomDelimiter(input: String): List<String> {
        if (input.startsWith("//") && input.contains("\\n")) {
            val slashesIndex = input.indexOf("//")
            val backSlashesIndex = input.indexOf("\\n")
            val customDelimiter = input.substring(slashesIndex + 2, backSlashesIndex)
            return splitDelimiter(customDelimiter, input.substring(backSlashesIndex + 2 until input.length))
        }
        return splitDelimiter(null, input)
    }

    private fun splitDelimiter(customDelimiter: String?, inputUser: String): List<String> {
        customDelimiter?.let { return inputUser.split(it, delimiters[0], delimiters[1]) }
        return inputUser.split(delimiters[0], delimiters[1])
    }

    private fun circulateValidator(splitInput: List<String>) {
        for (string in splitInput) {
            if (string.contains("-")) {
                throw IllegalArgumentException("음수를 입력할수 없습니다.")
            }
            if (string.isEmpty()) { // ex) ,1:2,3
                throw IllegalArgumentException("구분자를 먼저 입력할수 없습니다.")
            }
            invalidString(string)
        }
    }

    private fun invalidString(string: String) {
        for (ch in string) {
            if (!ch.isDigit()) {
                throw IllegalArgumentException("숫자 이외의 문자를 입력할수 없습니다.")
            }
        }
    }
}
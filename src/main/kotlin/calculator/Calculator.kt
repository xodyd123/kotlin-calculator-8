package calculator

class Calculator {
    fun circulate(inputUser: String): Int {
        val splitDelimiter = checkCustomDelimiter(inputUser)
    }

    private fun checkCustomDelimiter(input: String): List<String> {
        if (input.startsWith("//") && input.contains("\\n")) {
            val slashesIndex = input.indexOf("//")
            val backSlashesIndex = input.indexOf("\\n")
            val customDelimiter = input.substring(slashesIndex + 2, backSlashesIndex)
            return splitNumber(customDelimiter, input.substring(backSlashesIndex + 2 until input.length))
        }
        return splitNumber(null, input)
    }

    private fun splitNumber(customDelimiter: String?, inputUser: String): List<String>{
    }
}
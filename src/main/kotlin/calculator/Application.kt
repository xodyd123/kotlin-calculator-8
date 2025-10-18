package calculator

import camp.nextstep.edu.missionutils.Console


fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val inputUser = Console.readLine()
    val calculator = Calculator()
    val circulate = calculator.circulate(inputUser)
    println("결과 : $circulate")
}

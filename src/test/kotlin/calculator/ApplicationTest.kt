package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    @DisplayName("입력 값이 공백일때")
    fun emptyTest() {
        assertSimpleTest {
            run("\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    @DisplayName("구분자 사용")
    fun delimiterTest() {
        assertSimpleTest {
            run("1,2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    @DisplayName("커스텀 구분자와 구분자 함께 사용")
    fun delimitersTest() {
        assertSimpleTest {
            run("//.\\n1.2,3:5")
            assertThat(output()).contains("결과 : 11")
        }
    }

    @Test
    @DisplayName("입력값이 //-\n1,2-3 일때")
    fun minusDelimiterTest() {
        assertSimpleTest {
            run("//-\\n1,2-3")
            assertThat { output().contains("결과 : 6") }
        }
    }

    @Test
    @DisplayName("숫자 대신 구분자를 먼저 입력했을때")
    fun failDelimiterTest() {
        assertThrows<IllegalArgumentException> { runException("//-\\n-1,2,-3") }
    }

    override fun runMain() {
        main()
    }
}

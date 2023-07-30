import calculrate.SpringAddCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    SpringAddCalculator springAddCalculator = new SpringAddCalculator();
    @Test
    public void SpringAddCalculator_result_0() throws Exception {
        //given
        //when
        int result1 = springAddCalculator.splitAndSum("");
        int result2 = springAddCalculator.splitAndSum(null);
        //then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
    }

    @Test
    public void SpringAddCalculator_result_1number() throws Exception {
        //given
        //when
        int result = springAddCalculator.splitAndSum("1");
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void SpringAddCalculator_result_2number_comma() throws Exception {
        //given
        //when
        int result = springAddCalculator.splitAndSum("1,2");
        //then
        assertThat(result).isEqualTo(3);
    }
    
    @Test
    public void  SpringAddCalculator_result_3number_commaAndColon() throws Exception {
        //given
        //when
        int result = springAddCalculator.splitAndSum("1,2:3");
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void SpringAddCalculator_result_anyNumber_userCustom() throws Exception {
        //given
        //when
        int result = springAddCalculator.splitAndSum("//;\n1;2;3");
        //then
        assertThat(result).isEqualTo(6);
    }
    @Test
    public void SpringAddCalculator_result_minus() throws Exception {
        //given
        //when
        assertThatIllegalArgumentException().isThrownBy(() -> springAddCalculator.splitAndSum("-1,2,3"));
        //then
    }
    @Test
    public void SpringAddCalculator_result_String() throws Exception {
        //given
        //when
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> springAddCalculator.splitAndSum("1:ㅁ"));
    }
}

package ms.advent.dayone;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestCalibrationCodeShould {
    @Test
    void get_correct_first_digit() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "1abc2";
        assertThat(calibrate.getFirstNum(testCode), equalTo("1"));
    }

    @Test
    void get_correct_second_digit() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "pqr3stu8vwx";
        assertThat(calibrate.getLastNum(testCode), equalTo("8"));
    }

    @Test
    void get_two_different_digits() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "zoneight234";
        assertThat(calibrate.getTwoDigitCode(testCode), equalTo(24));
    }

    @Test
    void get_repeated_digits() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "two1nine";
        assertThat(calibrate.getTwoDigitCode(testCode), equalTo(11));
    }
}

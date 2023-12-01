package ms.advent.dayone;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestCalibrationCodeShould {
    @Test
    void has_numbers_map() {
        Map<String, String> numberStrings = CalibrationCode.numberStrings;
        assertThat(numberStrings.get("one"), equalTo("1"));
    }

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
        String testCode = "zoeght234";
        assertThat(calibrate.getTwoDigitCode(testCode), equalTo(24));
    }

    @Test
    void get_repeated_digits() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "twefs1ne";
        assertThat(calibrate.getTwoDigitCode(testCode), equalTo(11));
    }

    @Test
    void get_numbers_from_both_strings() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "eightwothree";
        assertThat(calibrate.getFirstNum(testCode), equalTo("8"));
        assertThat(calibrate.getLastNum(testCode), equalTo("3"));
        assertThat(calibrate.getTwoDigitCode(testCode), equalTo(83));
    }

    @Test
    void get_digits_from_int_and_string() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "nin8eight";
        assertThat(calibrate.getTwoDigitCode(testCode), equalTo(88));
    }

    @Test
    void get_numbers_from_overlapping_strings() {
        CalibrationCode calibrate = new CalibrationCode();
        String testCode = "sevenine";
        assertThat(calibrate.getTwoDigitCode(testCode), equalTo(79));
    }
}

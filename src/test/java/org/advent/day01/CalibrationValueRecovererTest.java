package org.advent.day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalibrationValueRecovererTest {

    @Test
    public void throwsRuntimeExceptionWhenNoFirstDigitFound() {
        assertThrows(RuntimeException.class, () -> {
            new CalibrationValueRecoverer().findFirstDigit("hello");
        });
    }

    @Test
    public void throwsRuntimeExceptionWhenNoLastDigitFound() {
        assertThrows(RuntimeException.class, () -> {
            new CalibrationValueRecoverer().findLastDigit("world");
        });
    }

    @Test
    public void findsFirstDigitInStringWithOnlyOneDigit() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('7', underTest.findFirstDigit("treb7uchet"));
    }

    @Test
    public void findsFirstDigitInStringWithTwoDigits() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('1', underTest.findFirstDigit("1abc2"));
        assertEquals('3', underTest.findFirstDigit("pqr3stu8vwx"));
    }

    @Test
    public void findsFirstDigitInStringWithMoreThanTwoDigits() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('1', underTest.findFirstDigit("a1b2c3d4e5f"));
    }

    @Test
    public void findsLastDigitInStringWithOnlyOneDigit() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('7', underTest.findLastDigit("treb7uchet"));
    }

    @Test
    public void findsLastDigitInStringWithTwoDigits() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('2', underTest.findLastDigit("1abc2"));
        assertEquals('8', underTest.findLastDigit("pqr3stu8vwx"));
    }

    @Test
    public void findsLastDigitInStringWithMoreThanTwoDigits() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('5', underTest.findLastDigit("a1b2c3d4e5f"));
    }


    @Test
    public void throwsRuntimeExceptionWhenRecoveringCalibrationValueFromStringWithNoDigits() {
        assertThrows(RuntimeException.class, () -> {
            new CalibrationValueRecoverer().recoverOne("hello");
        });
    }

    @Test
    public void recoversCalibrationValueForStringWithOnlyOneDigit() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals(77, underTest.recoverOne("treb7uchet"));
    }

    @Test
    public void recoversCalibrationValueForStringWithTwoDigits() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals(12, underTest.recoverOne("1abc2"));
        assertEquals(38, underTest.recoverOne("pqr3stu8vwx"));
    }

    @Test
    public void recoversCalibrationValueForStringWithMoreThanTwoDigits() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals(15, underTest.recoverOne("a1b2c3d4e5f"));
    }

    @Test
    public void recoversCalibrationValuesFromStringList() {
        var lines = Arrays.asList(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"
        );

        var underTest = new CalibrationValueRecoverer().recoverAll(lines);
        assertEquals(4, underTest.size());
        assertEquals(12, underTest.get(0));
        assertEquals(38, underTest.get(1));
        assertEquals(15, underTest.get(2));
        assertEquals(77, underTest.get(3));
    }

    @Test
    public void sumsToZeroForEmptyList() {
        var underTest = new CalibrationValueRecoverer().sum(Collections.emptyList());
        assertEquals(0, underTest);
    }

    @Test
    public void sumsCalibrationValuesRecoveredFromEachStringInList() {
        var lines = Arrays.asList(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"
        );

        var underTest = new CalibrationValueRecoverer().sum(lines);
        assertEquals(142, underTest);
    }

    @Test
    public void findsFirstDigitInSpelledOutString() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('2', underTest.findFirstDigit("two1nine"));
        assertEquals('8', underTest.findFirstDigit("eightwothree"));
        assertEquals('1', underTest.findFirstDigit("abcone2threexyz"));
        assertEquals('2', underTest.findFirstDigit("xtwone3four"));
        assertEquals('4', underTest.findFirstDigit("4nineeightseven2"));
        assertEquals('1', underTest.findFirstDigit("zoneight234"));
        assertEquals('7', underTest.findFirstDigit("7pqrstsixteen"));
    }

    @Test
    public void findsLastDigitInSpelledOutString() {
        var underTest = new CalibrationValueRecoverer();
        assertEquals('9', underTest.findLastDigit("two1nine"));
        assertEquals('3', underTest.findLastDigit("eightwothree"));
        assertEquals('3', underTest.findLastDigit("abcone2threexyz"));
        assertEquals('4', underTest.findLastDigit("xtwone3four"));
        assertEquals('2', underTest.findLastDigit("4nineeightseven2"));
        assertEquals('4', underTest.findLastDigit("zoneight234"));
        assertEquals('6', underTest.findLastDigit("7pqrstsixteen"));
    }

    @Test
    public void sumsCalibrationValuesRecoveredFromListContainingSpelledOutStrings() {
        var lines = Arrays.asList(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"
        );

        var underTest = new CalibrationValueRecoverer().sum(lines);
        assertEquals(281, underTest);
    }

}

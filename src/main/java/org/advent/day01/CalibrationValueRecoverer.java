package org.advent.day01;

import java.util.List;
import java.util.stream.Collectors;

public class CalibrationValueRecoverer {

    public char findFirstDigit(String line) {
        var chars = line.toCharArray();
        var digit = ' ';
        for (char c : chars) {
            if (Character.isDigit(c)) {
                digit = c;
                break;
            }
        }

        if (digit == ' ') {
            throw new RuntimeException("Digit not found in " + line);
        }

        return digit;
    }

    public char findLastDigit(String line) {
        var chars = line.toCharArray();
        var digit = ' ';
        for (var i = chars.length - 1; i >= 0; i--) {
            var c = chars[i];
            if (Character.isDigit(c)) {
                digit = c;
                break;
            }
        }

        if (digit == ' ') {
            throw new RuntimeException("Digit not found in " + line);
        }

        return digit;
    }

    public List<Integer> recoverAll(List<String> lines) {
        return lines.stream().map(this::recoverOne).collect(Collectors.toList());
    }

    public int recoverOne(String line) {
        var firstDigit = findFirstDigit(line);
        var lastDigit = findLastDigit(line);
        return Integer.parseInt("" + firstDigit + lastDigit);
    }

    public int sum(List<String> lines) {
        return recoverAll(lines).stream().mapToInt(Integer::intValue).sum();
    }

}

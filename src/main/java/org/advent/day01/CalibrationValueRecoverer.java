package org.advent.day01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalibrationValueRecoverer {

    private static final Map<String, Character> DIGIT_SPELLINGS = new HashMap<>(16);

    static {
        DIGIT_SPELLINGS.put("one", '1');
        DIGIT_SPELLINGS.put("two", '2');
        DIGIT_SPELLINGS.put("three", '3');
        DIGIT_SPELLINGS.put("four", '4');
        DIGIT_SPELLINGS.put("five", '5');
        DIGIT_SPELLINGS.put("six", '6');
        DIGIT_SPELLINGS.put("seven", '7');
        DIGIT_SPELLINGS.put("eight", '8');
        DIGIT_SPELLINGS.put("nine", '9');
    }

    private static final Pattern SPELLED_OUT_DIGIT_PATTERN = Pattern.compile(
            "one|two|three|four|five|six|seven|eight|nine"
    );

    public char findFirstDigit(String line) {
        for (var i = 0; i < line.length(); i++) {
            var c = line.charAt(i);
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }

            var matcher = SPELLED_OUT_DIGIT_PATTERN.matcher(line.substring(i));
            if (matcher.find() && matcher.start() == 0) {
                var matchedSpelling = matcher.group();
                return DIGIT_SPELLINGS.get(matchedSpelling);
            }
        }

        throw new RuntimeException("Digit not found in " + line);
    }

    public char findLastDigit(String line) {
        var returnVal = ' ';
        for (var i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                returnVal = line.charAt(i);
            }

            var matcher = SPELLED_OUT_DIGIT_PATTERN.matcher(line.substring(i));
            if (matcher.find() && matcher.start() == 0) {
                var matchedSpelling = matcher.group();
                returnVal = DIGIT_SPELLINGS.get(matchedSpelling);
            }
        }

        if (returnVal == ' ') {
            throw new RuntimeException("Digit not found in " + line);
        }

        return returnVal;
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

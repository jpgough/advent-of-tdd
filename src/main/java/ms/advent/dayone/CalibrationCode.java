package ms.advent.dayone;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.isDigit;

public class CalibrationCode {
    public static Map<String, String> numberStrings = new HashMap<>();

    static
    {
        numberStrings.put("one", "1");
        numberStrings.put("two", "2");
        numberStrings.put("three", "3");
        numberStrings.put("four", "4");
        numberStrings.put("five", "5");
        numberStrings.put("six", "6");
        numberStrings.put("seven", "7");
        numberStrings.put("eight", "8");
        numberStrings.put("nine", "9");
    }

    public String getFirstNum(String code) {

        int leftPointer = 0;
        String leftDigit = "";
        StringBuilder leftSubString = new StringBuilder();

        while (leftDigit.isEmpty()) {
            for (String numberString: numberStrings.keySet()) {
                if (String.valueOf(leftSubString).contains(numberString)) {
                    leftDigit = numberStrings.get(numberString);
                    break;
                }
            }

            if (leftDigit.isEmpty() && isDigit(code.charAt(leftPointer))) {
                leftDigit = String.valueOf(code.charAt(leftPointer));
            } else if (leftDigit.isEmpty()) {
                leftSubString.append(code.charAt(leftPointer));
                leftPointer++;
            }
        }

        return leftDigit;
    }

    public String getLastNum(String code) {

        int rightPointer = code.length() - 1;
        String rightDigit = "";
        String rightSubString = "";

        while (rightDigit.isEmpty()) {
            for (String numberString: numberStrings.keySet()) {
                if (String.valueOf(rightSubString).contains(numberString)) {
                    rightDigit = numberStrings.get(numberString);
                    break;
                }
            }

            if (rightDigit.isEmpty() && isDigit(code.charAt(rightPointer))) {
                rightDigit = String.valueOf(code.charAt(rightPointer));
            } else if (rightDigit.isEmpty()) {
                rightSubString = code.charAt(rightPointer) + rightSubString;
                rightPointer--;
            }
        }

        return rightDigit;
    }

    public int getTwoDigitCode(String code) {
        System.out.println(code);

        String firstDigit = this.getFirstNum(code);
        System.out.println(firstDigit);
        String lastDigit = this.getLastNum(code);
        System.out.println(lastDigit);
        String twoDigit = firstDigit + lastDigit;

        return Integer.parseInt(twoDigit);
    }



}

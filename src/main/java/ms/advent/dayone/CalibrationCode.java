package ms.advent.dayone;

import static java.lang.Character.isDigit;

public class CalibrationCode {

    public String getFirstNum(String code) {

        int leftPointer = 0;
        String leftDigit = "";

        while (leftDigit.isEmpty()) {
            if (isDigit(code.charAt(leftPointer))) {
                leftDigit = String.valueOf(code.charAt(leftPointer));
            } else {
                leftPointer++;
            }
        }

        return leftDigit;
    }

    public String getLastNum(String code) {

        int rightPointer = code.length() - 1;
        String rightDigit = "";

        while (rightDigit.isEmpty()) {
            if (isDigit(code.charAt(rightPointer))) {
                rightDigit = String.valueOf(code.charAt(rightPointer));
            } else {
                rightPointer--;
            }
        }

        return rightDigit;
    }

    public int getTwoDigitCode(String code) {
        String firstDigit = this.getFirstNum(code);
        String lastDigit = this.getLastNum(code);

        String twoDigit = firstDigit + lastDigit;

        return Integer.parseInt(twoDigit);
    }



}

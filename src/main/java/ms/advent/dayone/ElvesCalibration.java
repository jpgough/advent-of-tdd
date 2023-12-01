package ms.advent.dayone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ElvesCalibration {

    static CalibrationCode calibrate = new CalibrationCode();

    public static void main(String[] args) throws IOException {
        int codeSum = 0;
        Path path = Paths.get("src/main/resources/day-one-calibration-codes.txt");
        List<String> allCodes = Files.readAllLines(path);

        for (String code: allCodes) {
            int codeDigits = calibrate.getTwoDigitCode(code);
            codeSum += codeDigits;
        }

        System.out.println("The sum of codes is: " + codeSum);
    }

}

package org.advent;

import org.advent.day01.CalibrationValueRecoverer;
import org.advent.day01.ClasspathFileReader;

public class Main {

    public static void main(String[] args) {
        day01();
    }

    private static void day01() {
        var lines = new ClasspathFileReader().readAllLines("day01.input");
        var answer = new CalibrationValueRecoverer().sum(lines);
        System.out.println(answer);
    }

}

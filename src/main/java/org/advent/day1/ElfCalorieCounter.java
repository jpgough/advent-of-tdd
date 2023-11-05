package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;

public class ElfCalorieCounter {

    public ElfCalorieCounter(BufferedReader bufferedReader) {
        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

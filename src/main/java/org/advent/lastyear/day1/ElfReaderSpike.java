package org.advent.lastyear.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ElfReaderSpike {

    public static void main(String[] args) {
        List<Elf> elves = new ArrayList<>();

        //This will live in the main for this solution
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("day1-elf-calories.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        //This can be moved into an ElfReader classed and passed a BufferedReader
        try {
            Elf elf = new Elf();
            for (String line; (line = reader.readLine()) != null; ) {
                if(line.isBlank()) {
                    elves.add(elf);
                    elf = new Elf();
                } else {
                    elf.addCalories(Integer.valueOf(line));
                }
            }
            elves.add(elf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
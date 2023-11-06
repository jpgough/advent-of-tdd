package org.advent.day1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class Solution {

    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("day1-elf-calories.txt");

        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        ElfCalorieCounter elfCalorieCounter = new ElfCalorieCounter(reader);
        //Answer should be 70613
        System.out.println("Max Calories: " + elfCalorieCounter.maxCalories());
        //Answer should be 205805
        System.out.println("Max Three Calories: " + elfCalorieCounter.maxThree());
    }
}

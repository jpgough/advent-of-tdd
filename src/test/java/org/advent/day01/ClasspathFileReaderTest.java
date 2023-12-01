package org.advent.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClasspathFileReaderTest {

    @Test
    public void throwsRuntimeExceptionWhenReadingFileNotExists() {
        assertThrows(RuntimeException.class, () -> {
            new ClasspathFileReader().readAllLines("non-existent-file.txt");
        });
    }

    @Test
    public void readsLinesIntoListFromFile() {
        var underTest = new ClasspathFileReader().readAllLines("day01-part1.test");
        assertEquals(4, underTest.size());
        assertEquals("1abc2", underTest.get(0));
        assertEquals("pqr3stu8vwx", underTest.get(1));
        assertEquals("a1b2c3d4e5f", underTest.get(2));
        assertEquals("treb7uchet", underTest.get(3));
    }

}

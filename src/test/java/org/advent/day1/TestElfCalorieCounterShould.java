package org.advent.day1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestElfCalorieCounterShould {

    private ElfCalorieCounter elfCalorieCounter;

    @Test
    void throw_an_runtime_exception_when_reader_throws_io(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(new IOException());
        assertThrows(RuntimeException.class, () -> new ElfCalorieCounter(mockReader));
    }

    @Test
    void should_create_one_elf_with_maximum_calories_4000(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("3000")
                .thenReturn("1000")
                .thenReturn(null);
        elfCalorieCounter = new ElfCalorieCounter(mockReader);
        assertThat(elfCalorieCounter.maxCalories(), equalTo(4000));
    }

    @Test
    void create_two_elves_with_max_of_10_000(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("1000")
                .thenReturn("3000")
                .thenReturn("")
                .thenReturn("5000")
                .thenReturn("5000")
                .thenReturn(null);
        elfCalorieCounter = new ElfCalorieCounter(mockReader);
        assertThat(elfCalorieCounter.maxCalories(), equalTo(10_000));
    }

    @Test
    void create_four_elves_and_sum_calories_to_be_20_000(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("5000")
                .thenReturn("")
                .thenReturn("5000")
                .thenReturn("")
                .thenReturn("10000")
                .thenReturn("")
                .thenReturn("300")
                .thenReturn(null);

        elfCalorieCounter = new ElfCalorieCounter(mockReader);
        assertThat(elfCalorieCounter.maxThree(), equalTo(20_000));
    }
}

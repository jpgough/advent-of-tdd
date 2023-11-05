package org.advent.day1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestElfCalorieCounterShould {

    private ElfCalorieCounter elfCalorieCounter;

    @Test
    void throw_an_runtime_exception_when_reader_throws_io(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(new IOException());
        assertThrows(RuntimeException.class, () -> new ElfCalorieCounter(mockReader));
    }

}

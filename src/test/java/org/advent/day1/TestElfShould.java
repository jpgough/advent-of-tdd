package org.advent.day1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestElfShould {
    @Test
    void have_zero_total_calories_when_created() {
        Elf elf = new Elf();
        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void have_1000_total_calories_after_adding_1000() {
       fail("Not yet implemented");
    }

    @Test
    void have_total_calories_equal_to_all_added_calories() {
        fail("Not yet implemented");
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        fail("Not yet implemented");
    }

    @Test
    void compare_zero_for_equal_elf() {
        fail("Not yet implemented");
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        fail("Not yet implemented");
    }
}

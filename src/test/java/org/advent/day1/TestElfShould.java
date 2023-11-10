package org.advent.day1;

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
        Elf elf = new Elf();
        elf.addCalories(1000);
        assertThat(elf.getTotalCalories(), equalTo(1000));
    }

    @Test
    void have_total_calories_equal_to_all_added_calories() {
        Elf elf = new Elf();
        elf.addCalories(1000);
        elf.addCalories(2000);
        elf.addCalories(3000);
        assertThat(elf.getTotalCalories(), equalTo(6000));
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        Elf bigElf = new Elf();
        bigElf.addCalories(5000);
        Elf smallElf = new Elf();
        smallElf.addCalories(3000);
        assertThat(bigElf.compareTo(smallElf), greaterThan(0));
    }

    @Test
    void compare_zero_for_equal_elf() {
        Elf elf = new Elf();
        elf.addCalories(5000);
        assertThat(elf.compareTo(elf), equalTo(0));
    }
    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        Elf bigElf = new Elf();
        bigElf.addCalories(5000);
        Elf smallElf = new Elf();
        smallElf.addCalories(3000);
        assertThat(smallElf.compareTo(bigElf), lessThan(0));
    }
}
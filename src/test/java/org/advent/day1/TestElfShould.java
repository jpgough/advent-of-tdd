package org.advent.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Elf elf = new Elf();
        elf.addCalories(1000);
        assertEquals(elf.getTotalCalories(),1000);
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        Elf elfWithMoreCals = new Elf();
        elfWithMoreCals.addCalories(1000);
        elfWithMoreCals.addCalories(2000);
        elfWithMoreCals.addCalories(3000);

        assertEquals(elfWithMoreCals.getTotalCalories(),6000);

        Elf elfWithLessCals = new Elf();
        elfWithLessCals.addCalories(1000);

        assertEquals(elfWithMoreCals.compareTo(elfWithLessCals), 1);
    }

    @Test
    void compare_zero_for_equal_elf() {
        Elf elf1 = new Elf();
        elf1.addCalories(1000);

        assertEquals(elf1.getTotalCalories(),1000);

        Elf elf2= new Elf();
        elf2.addCalories(1000);

        assertEquals(elf1.compareTo(elf2), 0);
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        Elf elfWithMoreCals = new Elf();
        elfWithMoreCals.addCalories(1000);
        elfWithMoreCals.addCalories(2000);
        elfWithMoreCals.addCalories(3000);

        assertEquals(elfWithMoreCals.getTotalCalories(),6000);

        Elf elfWithLessCals = new Elf();
        elfWithLessCals.addCalories(1000);

        assertEquals(elfWithLessCals.compareTo(elfWithMoreCals), -1);

    }
}

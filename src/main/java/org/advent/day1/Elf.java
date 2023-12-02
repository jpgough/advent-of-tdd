package org.advent.day1;

/**
 * Elf that is assigned calories
 */
public class Elf implements Comparable<Elf> {

    private int totalCalories = 0;

    /**
     * Calories carried by the Elf
     * @return total calories
     */
    public int getTotalCalories() {
        return totalCalories;
    }

    @Override
    public int compareTo(Elf arg0) {
        int x = arg0.totalCalories;
        int y = this.totalCalories;
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

}

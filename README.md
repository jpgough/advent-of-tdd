## Exercise 1
### Part 2: Identifying tests from the requirements 

Looking at the problem the `Elf` is a key domain object and is a good place to start.
Looking at the last line in the text above we can also see that we're likely going to need to read in a file (our puzzle input) line by line.
Each blank line represents the creation of a new `Elf`.
This exercise is going to be quite simple, but let's focus on creating the following tests.

* Create an `Elf` and `assertThat` it has `getTotalCalories` of 0. 
This is our post condition of creating an `Elf`.
* Now let's use the example case to `addCalories(1000)` and call `getTotalCalories` to `assertThat` it is equal to 1000.
* Given that we're going to need to find the max calories, we're going to need to compare `Elf`s together. 
Let's use the Java standard for Comparing (e.g. `Comparable<Elf>`) to write some tests to compare `Elfs` for their total calories
You only need two tests for this.

In the `/src/main/java/org/advent/day1` package you will find a partially implemented `Elf` which implements the method `getTotalCalories` and an unimplemented `compareTo` method. In `/src/test/java/org/advent/day1` you will find a test class called `TestElfShould` which contains the implemented test `have_zero_total_calories_when_created` and the stubs for several other test cases we would suggest you implement. If you run the tests you should see the implemented one pass and all the others fail.

Try to implement all the other suggested test cases and update the `Elf` class to add the additional functionality required for them to pass.

When you're ready to move on go to the [exercise-2](https://github.com/jpgough/advent-of-tdd/tree/exercise-2) branch where you will also find one possible solution to the problem and the passing test cases.

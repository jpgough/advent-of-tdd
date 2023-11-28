## Exercise 3
### Mock Testing and Putting Everything Together

You can see a version of what we came up with in `/src/main/java/org/advent/day1/ElfReaderSpike`

Taking the content of the spike we created in exercise 2, let's create an `ElfCalorieCounter`.
This is going to take a `BufferedReader` as input, which can be quite tricky to test.
To test this collaboration we will use Mockito to create a mock `BufferedReader` and implement a few simple tests.
This will allow us to control the input and test the behaviour.

Try and create a test and set up your mock for the following scenarios:
* When `BufferedReader` throws an `IOException` expect an `RuntimeException`
* Creates an Elf when the file has two lines with 1000 and 3000 with value of 4000
   * NB you will note that our spike code in the given example solution contains a bug, can you spot and correct this whilst writing your tests? 
   * Add an `int maxElfCalories()`method to your `ElfCaloreCounter` and test that it returns 4000
* Creates a List<Elf> when the file has 5 lines with 1000, 3000, blank line, 5000, 5000
   * Use the `int maxElfCalories()` method to test that it returns 10,000


Add a `Solution` class that uses the other part of the spike to read in the input file and print the answer. 

![Puzzle requirement](/assets/requirements3.png)

The input file we have given you at `/src/main/resources/day1-elf-calories.txt` matches the input we were given in the example, does your `Solution` print `24000` as expected?

If it does, it's time to get your first `Star`; each contestants input is unique to themselves (to ensure you solved it rather than seeing someone else's answer). Make sure you're logged into [Advent of Code](https://adventofcode.com/) and you should be able to get your personal puzzle input [here](https://adventofcode.com/2022/day/1/input). Replace the contents of `day1-elf-calories.txt` with your personal input and rerun the solution to get your answer!

Does it work as expected?

You can find the solution and the expected value based on our input file in the [exercise-4](https://github.com/jpgough/advent-of-tdd/tree/exercise-4) branch.

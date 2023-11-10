## Exercise 3
### Mock Testing and Putting Everything Together

Taking the content of the spike we created in exercise 2, let's create an `ElfCalorieCounter`.
This is going to take a `BufferedReader` as input, which can be quite tricky to test.
To test this collaboration we will use Mockito to create a mock `BufferedReader` and implement a few simple tests.
This will allow us to control the input and test the behaviour.

Try and create a test and set up your mock for the following scenarios:
* When `BufferedReader` throws an `IOException` expect an `RuntimeException`
* Creates an Elf when the file has two lines with 1000 and 3000 with value of 4000
   * NB you will note that our spike code in the given example solution contains a bug, can you spot and correct this whilst writing your tests? 
   * Add an `int maxElfCalories()` and test that it returns 4000
* Creates a List<Elf> when the file has 5 lines with 1000, 3000, blank line, 5000, 5000
   * `int maxElfCalories()` and test that it returns 10,000

Add a `Solution` class that uses the other part of the spike to read in the input file and print the answer to the problem.

Does it work as expected?

You can find the solution and the expected value in the [exercise-4](https://github.com/rocketstack-matt/advent-of-tdd/tree/exercise-4-refactor) branch.
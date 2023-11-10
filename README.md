## Exercise 1
### Part 2: Identifying tests from the requirements 

Lets look again at [Part 1](day1-part1.md) of the puzzle.

![Puzzle requirements](/assets/requirements2.png)

The next part of the puzzle shows us what a puzzle input may look like and we can see for ourselves it represents 5 `Elves` because there are 5 separate blocks of numbers, each separated by a new line, which we already know represents creating a new `Elf`.

What's more, the puzzle is actually giving us some test cases.
* The first `Elf` should be carrying the sum of `1000 + 2000 + 3000 = 6000` calories
* The second `Elf` is carrying only a single item so should have a calorie count of `4000`
* The third `Elf` should be carrying the sum of `5000 + 6000 = 11000` calories
* The fourth `Elf` should be carrying the sum of `7000 + 8000 + 9000 = 24000` calories
* The fifth `Elf` is carrying only a single item so should have a calorie count of `10000`

Add additional tests to the `TestElfShould` class to capture the above scenarios. 

Once you're happy your solution can solve the provided test cases, lets go to [exercise-3](https://github.com/rocketstack-matt/advent-of-tdd/tree/exercise-3-refactor)


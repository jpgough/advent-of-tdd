# Advent of TDD

A follow along workshop to introduce the idea and concepts of using TDD for [Advent of Code](https://adventofcode.com) problems.

## Introduction

[Advent of Code](https://adventofcode.com/2023/about) is an annual coding contest run by [Eric Wastl](https://github.com/topaz) run during the Christmas advent period each year. The contest posts a new puzzle each day of advent and you're free to use whatever language you like to find a solution to the puzzles.

Each day is split into two parts, the second of which is only shown to you once you have solved the first part. And be warned, the puzzles can get hard fast!

Advent of Code is a great opportunity to try to learn a new language or hone your coding skills and we're going to use it as an opportunity to apply [Test Driven Development](https://en.wikipedia.org/wiki/Test-driven_development) techniques.

## Workshop

In this workshop you will use the Day 1 problem from Advent of Code 2022.
In the following exercises you will review the day 1 instructions, design and implement your tests first. We will guide you on some of the design and thought process behind each exercise.

The workshop is split up by branches, each branch will provide you with the next exercise which you will work through yourself to try and solve. In each subsequent exercise we will also provide a possible solution for the prior exercise, so you if you do get stuck you can look at what you may have missed.

You are currently in the `main` branch. You will see other branches called `exercise-1` to `exercise-4` you should work you way through these branches in numerical order to work your way through the tutorial.

## Getting setup

Whilst you're welcome to follow these exercises in any language of your choosing and the lessons should be equally applicable from a problem solving perspective, the code provided here is written using Java.

We've tried to make this workshop as accessible as possible. Every branch contains a `.devcontainer` folder which is a preconfigured development environment.

To get started we recommend you `fork` this repo so you have your own copy to work on. You can either clone your fork to your local computer and work with any IDE or text editor of your choice, but if you use one which supports [devcontainers](https://code.visualstudio.com/docs/devcontainers/containers) such as VS Code then the `.devcontainers` configuration in this repo will suggest you install the devcontainers extension and if you do so then it can use that information to automatically install the tools you will need including the JDK and Maven.

If you want to make it even easier you can use [GitHub Codespaces](https://github.com/features/codespaces) which are cloud hosted development environments. Every GitHub account comes with a number of free devcontainer hours, even the free ones, so if you would like to do that take a look at the [codespaces](https://github.com/jpgough/advent-of-tdd/tree/codespaces) branch which will explain in detail how to use them.

## Let's get started

If you're ready to go, switch to the [exercise-1](https://github.com/jpgough/advent-of-tdd/tree/exercise-1) branch and get moving. Happy coding!

## Exercises

### Exercise 1, Part 1: Breaking up the Problem - Unit Testing 

Start by reading the instructions for [Part 1](day1-part1.md).
As with regular requirements, there's a lot of extra information surrounding what you need to implement.
To solve the first part of the problem there are a few pieces to consider.
You are not going to go straight to getting the answer required by the exercise, instead we are going to start by focusing on the `Elf`.

Looking at the problem the `Elf` is a key domain object and is a good place to start.
Approaching this problem I would look at the requirements and note that we are likely going to be reading line-by-line a file.
Each blank line represents the creation of a new `Elf`.
This exercise is going to be quite simple, but let's focus on creating the following tests.

* Create an `Elf` and `assertThat` it has `getTotalCalories` of 0. 
This is our post condition of creating an `Elf`.
* Now let's use the example case to `addCalories(1000)` and call `getTotalCalories` to `assertThat` it is equal to 1000.
* Now let's `addCalories(1000)`, `addCalories(2000)`, `addCalories(3000)` and call `getTotalCalories` to `assertThat` it is equal to 6000.
* Given that we're going to need to find the max calories, we're going to need to compare `Elf`s together. 
Let's use the Java standard for Comparing (e.g. `Comparable<Elf>`) to write some tests to compare `Elfs` for their total calories
You only need two tests for this.

Check your solution against the `exercise-1` branch.

### Exercise 2, Part 1: Spike - Reading in Input

Reading input from a file in Java is not always straight forward.
There will often be times that it is difficult to figure out which library you need or how to do something.
In this Exercise we will create a spike, in this spike we're exploring without any pressure to test.
You should experiment how to read the file into a `Collection<Elf>`.

Spikes are a useful way to explore before we write our tests.
Check out your spike vs the spike in the `exercise-2` branch.

### Exercise 3, Part 1: Mock Testing and Putting Everything Together

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

Add a `Solution` class that uses the other part of the spike to read in the file and print the answer to the problem.
Does it work as expected?
You can find the solution and the expected value in the `exercise-3` branch.

### Exercise 4, Part 2: A New Part of the Problem

[Part 2](/day1-part2.md) brings in a change in the requirements. 
The change is quite easy to implement, we now need to find the top 3 total calories for the Elves.
Let's add a new test to `TestElfCalorieCounter` to finish today's puzzle.
You can find the solution in the `exercise-4` branch.

A big part of TDD is following the Red, Green, Refactor processes.
Spend some time working through both the tests and the subject under test and refactor as necessary.
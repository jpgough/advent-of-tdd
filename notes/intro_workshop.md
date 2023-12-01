## Intro Presentation

### The Basics

- Red: write the test, fix compilation issues, prove the test fails
- Green: make the test pass
- Refactor: improve the subject under test, improve the test

### Styles

1. Outside-In

LDN approach. Focus on what the user needs from the code, and defines the test based on this. Leads you to MVP solution for the problem. You can then work in.

2. Inside-Out

Start with lower levels and work outwards. The TDD is going to be this style.

### Unit Tests

- isolated subject under test i.e. one public method in a class.
- repeatable, isolated, and gives fast results.
- must have some assertions. they give the quality
- us supported test framework
- start with edge and exception cases

### Spikes

Can help with getting overloaded by discovery, all about the test and the subject under test.
Guides you to create a branch, experiment without tests and hack something together, then return to your main and teset with your informed approach.

### Mocking

Used to isolate dependencies.

- Dummy: not used in test
- Stubs: returns pre-defined values when something happens
- Spy: checks or verifies a mock was called in specific values
- Fake: could be a hand crafted mock. often useful in integration tests

They define intential seams between code - you know what the contract is there.

### Examples

- test cases in snake case (python-esque) to make it easier to read.


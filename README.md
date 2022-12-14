# Advent of Code Clojure 2022

## Progress

- [x] Day 1: Calorie Counting
- [x] Day 2: Rock Paper Scissors
- [x] Day 3: Rucksack Reorganization
- [x] Day 4: Camp Cleanup (not really happy with me overusing sets here)
- [ ] Day 5: 

## Usage

There are 25 namespaces, 25 input files 25 example input files, 25 tests, and 50 `lein` tasks. 

1. Fill in the tests with the example solutions.
1. Write your implementation.
1. Fill in the final problem inputs into the `lein` task and run `lein run d01.p1`!

```clojure
(ns advent-of-code.day-01)

(defn part-1
  "Day 01 Part 1"
  [input]
  input)

(defn part-2
  "Day 01 Part 2"
  [input]
  input)
```

```clojure
(ns advent-of-code.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-code.day-01 :refer [part-1 part-2]]
            [clojure.java.io :refer [resource]]))

(deftest part1
  (let [expected nil]
    (is (= expected (part-1 (slurp (resource "day-1-example.txt")))))))

(deftest part2
  (let [expected nil]
    (is (= expected (part-2 (slurp (resource "day-1-example.txt")))))))
```

## Installation

```bash
# clone
$ git clone git@github.com:mhanberg/advent-of-code-clojure-starter.git advent-of-code
$ cd advent-of-code

# Reinitialize your git repo
$ rm -rf .git
$ git init
```

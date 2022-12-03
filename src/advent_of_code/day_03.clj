(ns advent-of-code.day-03
  (:require [clojure.set :as set])
  )

(def item-priority-list
  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn item-priority [item]
  (inc (.indexOf item-priority-list (str item))))

(def example-data
  "vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
ab
CrZsJsPPZsGzwwsLwLmpwMDw")

(defn find-duplicate-items [s]
  (->> s
     (split-at (* 0.5 (count s)))
     (map set)
     (reduce set/intersection)
     (vec)
     (map item-priority)))

(defn part-1
  "Day 03 Part 1"
  [input]
  (->>
   input
   (clojure.string/split-lines)
   (map find-duplicate-items)
   (flatten)
   (reduce +)))

(def example-data-2
  "vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw")

(defn find-duplicate-items-in-3 [[x y z]]
  (set/intersection (set x) (set y) (set z))
  )

(find-duplicate-items-in-3 (take 3 (clojure.string/split-lines example-data-2)))

(defn part-2
  "Day 03 Part 2"
  [input]
  (->>
   input
   (clojure.string/split-lines)
   (partition-all 3)
   (map find-duplicate-items-in-3)
   (map vec)
   (flatten)
   (map item-priority)
   (reduce +)))

(part-2 example-data-2)

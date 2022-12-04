(ns advent-of-code.day-04
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(def example
  "2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8")

(defn parse-data [data]
  (partition-all 4
                 (map #(Integer/parseInt %)
                      (str/split data #"[-,\n]"))))

(defn expand-regions
  ([a b] (range a (inc b)))
  ([a b c d]
   [(set (expand-regions a b)) (set (expand-regions c d))]))

(defn are-subsets? [a b]
  (or
   (set/subset? a b)
   (set/subset? b a)))

(defn overlaps? [a b]
  (seq (set/intersection a b)))

(defn part-1
  "Day 04 Part 1"
  [input]
  (->>
   input
   (parse-data)
   (map #(apply expand-regions %))
   (map #(apply are-subsets? %))
   (map #({true 1 false 0} %))
   (reduce +)))

(part-1 example)

(defn part-2
  "Day 04 Part 2"
  [input]
  (->>
   input
   (parse-data)
   (map #(apply expand-regions %))
   (map #(apply overlaps? %))
   (remove nil?)
   (count)))

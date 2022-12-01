(ns advent-of-code.day-01)

(defn parse-lists [ls]
  (for [l ls]
    (map read-string l)))

(defn parse-input [input]
  (->>
   input
   (clojure.string/split-lines)
   (partition-by clojure.string/blank? )
   (remove #(= '("") %))
   (parse-lists)
   (map vec)))

(defn calories-per-bags [c]
  (map #(apply + %) c))

(defn part-1
  "Day 01 Part 1"
  [input]
  (let [in (parse-input input)]
    (apply max (calories-per-bags in))))

(defn part-2
  "Day 01 Part 2"
  [input]
  (let [in (parse-input input)]
    (reduce + (take 3 (sort > (calories-per-bags in))))))

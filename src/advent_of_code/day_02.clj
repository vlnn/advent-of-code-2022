(ns advent-of-code.day-02)

(defn parse-input [input]
  (partition-all 2 (clojure.string/split input #" |\n")))

(def attack-price {"A" 1 "B" 2 "C" 3})
(def defence-price {"X" 1 "Y" 2 "Z" 3})

(defn count-result [q w]
  (let [at (get attack-price q)
        df (get defence-price w)]
    (cond
      (= 0 (- df at))         (+ df 3)
      (= 1 (- df at))         (+ df 6)
      (and (= df 1) (= at 3)) (+ df 6)
      :else                   df)))

(comment
  (count-result "B" "X") ;; p>r, 1
  (count-result "B" "Y") ;; p=p, 5
  (count-result "A" "Z") ;; r>s, 3
  (count-result "C" "X") ;; s<r, 7
  (count-result "C" "Z") ;; s=s, 6
  (count-result "C" "Y") ;; s>p, 2
)

(defn part-1
  "Day 02 Part 1"
  [input]
  (->>
   input
   (parse-input)
   (map #(apply count-result %))
   (reduce +)))

(comment
  X lose
  Y draw
  Z win
  )

(defn consult-move [q w]
  "Calculate next move using move of attacker q and needed result w"
  (comment
    + A B C
    X 3 1 2
    Y 4 5 6
    Z 8 9 7)
  (let [at    (dec (get attack-price q))
        gl    (dec (get defence-price w))
        moves [[3 1 2] [4 5 6] [8 9 7]]]
    (get (get moves gl) at)))

(defn part-2
  "Day 02 Part 2"
  [input]
  (->>
   input
   (parse-input)
   (map #(apply consult-move %))
   (reduce +)))

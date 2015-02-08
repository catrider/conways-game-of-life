(ns conways-game-of-life.grid-slurper)

(defn drop-tail
  [seq]
  (take (- (count seq) 1) seq))

(defn slurp-grid
  [filepath]
  (->> (slurp filepath)
       seq
       (partition-by #{\newline})
       (remove #{(list \newline)})
       rest
       drop-tail
       (map (comp
             (partial map #(case % \space 0 \* 1 0))
             flatten
             (partial partition 1 2)
             rest
             drop-tail))))

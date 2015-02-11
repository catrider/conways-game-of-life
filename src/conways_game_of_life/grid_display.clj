(ns conways-game-of-life.grid-display
  (:require [conways-game-of-life.grid :as g]))

(defn- thread-last-conj
  [e vec]
  (conj vec e))

(defn- grid-border
  [grid]
  (vec (flatten (repeat (g/width grid) (list \space \-)))))

(defn display-grid
  [grid]
  (->> (map (fn [row] (map (fn [v] (case v 0 \space 1 \*)) row)) grid)
       (map (comp (partial cons \|) #(conj % \| \newline) vec (partial interpose \space)))
       vec
       (thread-last-conj (grid-border grid))
       (cons (conj (grid-border grid) \newline))
       flatten
       (apply str)))

(ns conways-game-of-life.grid)

(defn width
  [[first-row & more-rows :as grid]]
  (count first-row))

(defn height
  [grid]
  (count grid))

(defn value-at-cell
  [grid [x y :as cell]]
  (get (get grid x) y))

(defn live-neighbors-count
  [grid [x y :as cell]]
  (count
   (filter
    (partial = 1)
    (map
     (partial value-at-cell grid)
     (for [x (range (- x 1) (+ x 2))
           y (range (- y 1) (+ y 2))]
       (vector x y))))))

(defn next-generation
  [grid]
  (partition
   (width grid)
   (map
    (fn next-generation-cell
      [cell]
      (let [live-neighbors-count (live-neighbors-count grid cell)]
        (cond
         (< 2 live-neighbors-count) 0
         (and
          (>= 2 live-neighbors-count)
          (<= 3 live-neighbors-count)) 1
         :else 0)))
    (for [x (range (height grid))
          y (range (width grid))]
      (vector x y)))))

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

(defn- neighbor-cells
  [grid [cx cy :as target-cell]]
  (for [x (range (- cx 1) (+ cx 2))
        y (range (- cy 1) (+ cy 2))
        :when (not= target-cell (list x y))]
    (vector x y)))

(defn live-neighbors-count
  [grid [cx cy :as target-cell]]
  (count
   (filter
    (partial = 1)
    (map
     (partial value-at-cell grid)
     (neighbor-cells grid target-cell)))))

(defn- alive?
  [grid [cx cy :as target-cell]]
  (= 1 (value-at-cell grid target-cell)))

(defn next-generation-cell
  [grid cell]
  (let [live-neighbors-count (live-neighbors-count grid cell)
        live-neighbors-count-equals? (partial = live-neighbors-count)]
    (if (alive? grid cell)
      (cond
       (or
        (live-neighbors-count-equals? 2)
        (live-neighbors-count-equals? 3)) 1
        :else 0)
      (if (live-neighbors-count-equals? 3)
        1
        0))))


(defn all-cells
  [grid]
  (for [x (range (height grid))
            y (range (width grid))]
        (vector x y)))

(defn next-generation
  [grid]
  (->> (map (partial next-generation-cell grid) (all-cells grid))
       (partition (width grid))
       (map vec)
       (vec)))

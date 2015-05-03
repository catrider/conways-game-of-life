(ns conways-game-of-life.game.run
  (:require [conways-game-of-life.game.grid-slurper :as grid-slurper])
  (:require [conways-game-of-life.game.grid :as grid]))

(defn -main
  [& args]
  (let [init-grid (grid-slurper/slurp-grid (first args))]
    (loop [grid init-grid]
      (println ))))

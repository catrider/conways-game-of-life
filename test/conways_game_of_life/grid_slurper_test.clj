(ns conways-game-of-life.grid-slurper-test
  (:require [clojure.test :refer :all]
            [conways-game-of-life.grid-slurper :refer :all]))

(deftest slurp-grid-test
  (testing "slurp-grid parses a file and returns a grid"
    (is (= [[0 1 0 1]
            [1 0 0 0]
            [0 1 1 0]
            [1 1 0 1]] (slurp-grid "resources/grid_test_file.txt")))))


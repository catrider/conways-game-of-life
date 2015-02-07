(ns conways-game-of-life.grid-test
  (:require [clojure.test :refer :all]
            [conways-game-of-life.grid :refer :all]))

(deftest next-test
  (testing "Any live cell with fewer than two live neighbours dies, as if caused by under-population"
    (testing "Any live cell with 0 neighbours dies"
      (is (= 0
             (value-at-cell (next-generation [[0 0 0]
                                              [0 1 0]
                                              [0 0 0]]) [1 1]))))
    (testing "Any live cell with 1 neighbours dies"
      (is (= 0
             (value-at-cell (next-generation [[1 0 0]
                                              [0 1 0]
                                              [0 0 0]]) [1 1])))))
  (testing "Any live cell with two or three live neighbours lives on to the next generation"
    (testing "Any live cell with 2 neighbours lives"
      (is (= 1
             (value-at-cell (next-generation [[0 1 0]
                                              [0 1 1]
                                              [0 0 0]]) [1 1]))))
    (testing "Any live cell with 3 neighbours lives"
      (is (= 1
             (value-at-cell (next-generation [[0 1 0]
                                              [0 1 1]
                                              [1 0 0]]) [1 1])))))
  (testing "Any live cell with more than three live neighbours dies, as if by overcrowding"
    (testing "Any live cell with 4 neighbours dies"
      (is (= 0
             (value-at-cell (next-generation [[1 1 0]
                                              [0 1 1]
                                              [1 0 0]]) [1 1]))))
    (testing "Any live cell with 5 neighbours dies"
      (is (= 0
             (value-at-cell (next-generation [[0 1 1]
                                              [0 1 1]
                                              [1 1 0]]) [1 1]))))
    (testing "Any live cell with 6 neighbours dies"
      (is (= 0
             (value-at-cell (next-generation [[1 1 1]
                                              [0 1 1]
                                              [1 0 1]]) [1 1]))))
    (testing "Any live cell with 7 neighbours dies"
      (is (= 0
             (value-at-cell (next-generation [[0 1 1]
                                              [1 1 1]
                                              [1 1 1]]) [1 1]))))
    (testing "Any live cell with 8 neighbours dies"
      (is (= 0
             (value-at-cell (next-generation [[1 1 1]
                                              [1 1 1]
                                              [1 1 1]]) [1 1]))))))

(deftest live-neighbors-count-test
  (testing "Returns number of live neighbors of a cell"
    (testing "When target cell is in the middle of the grid"
      (is (= 5 (live-neighbors-count [[0 1 1]
                                      [1 0 1]
                                      [1 0 0]] [1 1]))))
    (testing "And doesn't include the target coordinate"
      (is (= 5 (live-neighbors-count [[0 1 1]
                                      [1 1 1]
                                      [1 0 0]] [1 1]))))))

(deftest value-at-cell-test
  (testing "Returns the value at the passed cell"
    (is (= 0 (value-at-cell [[0 1 1]
                             [1 0 1]
                             [1 0 0]] [0 0])))
    (is (= 1 (value-at-cell [[0 1 1]
                             [1 0 1]
                             [1 0 0]] [0 1])))
    (is (= 1 (value-at-cell [[0 1 1]
                             [1 0 1]
                             [1 0 0]] [1 0])))
    (is (= 1 (value-at-cell [[0 1 1]
                             [1 0 1]
                             [1 0 0]] [1 2])))
    (is (= 0 (value-at-cell [[0 1 1]
                             [1 0 1]
                             [1 0 0]] [2 2])))))

(deftest width-test
  (testing "Returns the width of the grid"
    (is (= 4 (width [[0 1 1 0]
                     [0 1 0 1]
                     [1 1 0 0]])))
    (is (= 10 (width [[0 1 1 0 0 0 0 0 1 1]
                      [0 1 0 1 0 1 1 0 1 0]])))))

(deftest height-test
  (testing "Returns the width of the grid"
    (is (= 3 (height [[0 1 1 0]
                      [0 1 0 1]
                      [1 1 0 0]])))
    (is (= 2 (height [[0 1 1 0 0 0 0 0 1 1]
                      [0 1 0 1 0 1 1 0 1 0]])))))



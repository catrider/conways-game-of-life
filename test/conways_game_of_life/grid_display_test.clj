(ns conways-game-of-life.grid-display-test
  (:require [clojure.test :refer :all]
            [conways-game-of-life.grid-display :refer :all]))

(deftest display-grid-test
  (testing "a 4x4 grid is displayed"
    (is (= (str " - - - -\n"
                "|  * * *|\n"
                "|*     *|\n"
                "|      *|\n"
                "|  * *  |\n"
                " - - - -" )
           (display-grid [[0 1 1 1]
                          [1 0 0 1]
                          [0 0 0 1]
                          [0 1 1 0]]))))
  (testing "an 8x10 grid is displayed"
    (is (= (str " - - - - - - - - - -\n"
                "|  * * *   * * *   *|\n"
                "|*     *     * *    |\n"
                "|      *   * * * *  |\n"
                "|  * *   *     *   *|\n"
                "|*     * *   * *    |\n"
                "|* *     * *   *    |\n"
                "|  *         *     *|\n"
                "|* *     *     * * *|\n"
                " - - - - - - - - - -")
           (display-grid [[0 1 1 1 0 1 1 1 0 1]
                          [1 0 0 1 0 0 1 1 0 0]
                          [0 0 0 1 0 1 1 1 1 0]
                          [0 1 1 0 1 0 0 1 0 1]
                          [1 0 0 1 1 0 1 1 0 0]
                          [1 1 0 0 1 1 0 1 0 0]
                          [0 1 0 0 0 0 1 0 0 1]
                          [1 1 0 0 1 0 0 1 1 1]])))))

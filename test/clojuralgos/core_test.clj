(ns clojuralgos.core-test
  (:require [clojure.test :refer :all]
            [clojuralgos.core :refer :all]))

(deftest simple-pig-latin-test
  (testing "It functions as expected"
    (let [test1 (simple-pig-latin "Pig latin is cool")
          test2 (simple-pig-latin "This is my string")]
      (is (= test1 "igPay atinlay siay oolcay"))
      (is (= test2 "hisTay siay ymay tringsay")))))

(deftest alphabet-symmetry-test
  (let [test1 (alphabet-symmetry ["abode" "ABc" "xyzD"])
          test2 (alphabet-symmetry ["abide" "ABc" "xyz"])]
      (is (= test1 [4 3 1]))
      (is (= test2  [4 3 0]))))

(deftest row-weights-test
  (let [test1 (row-weights [50 60 70 80])
          test2 (row-weights [29 83 67 53 19 28 96])]
      (is (= test1 '(120 140)))
      (is (= test2  '(211 164)))))

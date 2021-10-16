(ns clojuralgos.core
  (:gen-class))
(require '[clojure.string :as str])

(defn -main
  "I don't do a whole lot ... yet."
  []
  (println "Hello, World!"))

(defn pig-latinize [word]
  (if (re-matches #"\w+" word)
    (let [letters (str/split word #"")]
     (str/join
       #""
       (concat
         (concat (rest letters) (take 1 letters)) ["a" "y"])))
    word))
   
   
;; Simple Pig Latin
(defn simple-pig-latin
  "Takes a string and converts it to pig latin
  by placing the first character at the end of
  the word and appending 'lay' to it"
  [str]
  (let [words (str/split str #" ")]
    (str/join  #" " (map pig-latinize words))))
    
   
;; Alphabet symmetry

(defn chr-pos-same [char x]
  (when (str/blank? char) nil)
  (=
    (-
      (int (.charAt (str/lower-case (str char)) 0))
      97)
    x))
  
(defn chr-pos-reducer [sum idx chr]
 (+
  sum
  (if (true? (chr-pos-same chr idx))
    1
    0)))

(defn chr-pos-mppr [word]
  (reduce-kv
    chr-pos-reducer
    0
    (str/split word #"")))

(chr-pos-mppr "XlFghtgUMyy")

(defn alphabet-symmetry
  "Takes an array of words, returns an array
  of the number of letters that occupy their
  positions in the alphabet for each word"
  [arr]
 (map chr-pos-mppr arr))

;; Row Weights

(defn get-row-weight [vect odds?]
  (reduce-kv
    (fn [total-weight idx weight]
      (if
        (or
            (and
              (even? idx)
              odds?)
            (and
              (not(even? idx))
              (not odds?)))
        total-weight
        (+
         total-weight
         weight)))
   0 
   vect))
                
  
(defn row-weights
  "Takes a vector of positive integers,
  returns a vector of two integers,
  the total weight of team 1
  and the total weight of team 2"
  [weights]
  (let [weights-vect (into [] weights)]
    (map #(get-row-weight weights-vect %) [false true])))

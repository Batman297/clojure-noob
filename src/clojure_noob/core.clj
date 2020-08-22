(ns clojure-noob.core
  (:use [clojure.string :only (join)])
  (:use [clojure.set :only (superset?)]))

;; Clojure basic part one

(def mylist '(1 2 3 4 5 6 7 8 9 10))

(def myvec [1 2 3 4 5 6 7 8 9 10])

(def myset #{1 2 3 4 5 6 7 8 9 10})

(def mymap {:a 1 :b 2 :c 3 :d 4 :e 5})

(def person {:nama "denda" :umur "muda" :alamat "jauh banget"})

(def mykeylist '(:a :b :c :d))

(def mykeyvec [:a :b :c :d])

;; Clojure basic part two

(defn square 
  [x] 
  (* x x))

(defn pk
  [a b c]
  (fn [x]
    (+ (* a (square x))
       (* b x)
       c)))

(defn mutlak
  [x]
  (if (pos? x) x (- x)))

(defn explain
  [something]
  (case something
    :a "yeeey aaa"
    :b "ini b"
    :nothing
    :else))


(defn kecap
  ;; rumus kecap
  [a b c]
  (let [adet (Math/sqrt (- (* b b) (* 4 a c)))]
    [(/ (- (- b) adet) (* 2 a))
     (/ (+ (- b) adet) (* 2 a))]))

(defn ngasal
  [x]
  (let [a (* x x)]
    (let [b (* a 2)]
      (* a b x))))

(defn fibo
  [x]
  (case x
    1 0
    2 1
    (+ (fibo (- x 1)) (fibo (- x 2)))))

;; projecteuler problem 1
(defn prob1
  [[x & xs :as lst]]
  (cond 
    (empty? lst) '()
    (= 1 (count lst)) (list x)
    (or (zero? (rem x 3)) (zero? (rem x 5))) (cons x (prob1 xs))
    :else (prob1 xs)))

;; Clojure basic part three

(defn iter-prime
  [x i]
  (cond
    (= x i) true
    (zero? (rem x i)) false
    :else (iter-prime x (inc i))))

(defn prime?
  [x]
  (cond 
    (<= x 1) false
    (= x 2) true
    :else (iter-prime x 2)))

(defn prime?2
  [x]
  (let [iter (fn iter 
               [i]
               (cond
                 (= x i) true
                 (zero? (rem x i)) false
                 :else (iter (inc i))))]
  (cond
    (<= x 1) false
    (= x 2) true
    :else (iter 2))))

(defn prime?3
  [x]
  (let [iter (fn iter 
               [i]
               (cond
                 (= x i) true
                 (zero? (rem x i)) false
                 :else (iter (+ i 2))))]
    (cond
      (<= x 1) false
      (= x 2) true
      (even? x) false
      :else (iter 3))))

(defn fak
  [x]
  (if (= x 1)
    1
    (*' x (fak (dec x)))))

(defn folding
  [f [x & xs]]
  (if x  
    (f x (folding f xs))
    (f)))

;; re-implement several clojure's functions
;; sum product quot rem mod inc dec
;; take drop zipmap map take-while drop-while

(defn sum
  ;; nambahin semua 
  [[x & xs]]
  (if x
    (+ x (sum xs))
    0))

(defn product
  ;; ngaliin semua
  [[x & xs]]
  (if x
    (* x (product xs))
    1))

(defn mutlak
  ;; nilai mutlak
  [x]
  (if (neg? x)
    (- x)
    x))

(defn my-rem
  ;; sisa bagi x oleh y
  [x y]
  (let [y (mutlak y)]
    (cond
      (< (mutlak x) y) x
      (neg? x) (my-rem (+ x y) y)
      :else (my-rem (- x y) y))))

;; tryone
;; my-rem 9 -2
;; my-rem (- 9 (mutlak -2)) -2 => 9 2
;; my-rem (- 7 (mutlak -2)) -2 => 7 2
;; my-rem (- 5 (mutlak -2)) -2 => 5 2
;; my-rem (- 3 (mutlak -2)) -2 => 3 2
;; my-rem (- 1 (mutlak -2)) -2 => 1

;; my-rem -9 -2
;; my-rem (+ -9 (mutlak -2)) -2 => -9 2
;; my-rem (+ -7 (mutlak -2)) -2 => -7 2
;; my-rem (+ -5 (mutlak -2)) -2 => -5 2
;; my-rem (+ -3 (mutlak -2)) -2 => -3 2
;; my-rem (+ -1 (mutlak -2)) -2 => -1

(defn my-quot
  ;; hasil bagi x oleh y
  [x y]
  (cond
    (< (mutlak x) (mutlak y)) 0
    (or (and (pos? x)
             (pos? y)) 
        (and (neg? x)
             (neg? y))) (+ (my-quot (- x y) y) 1)
    :else (- (my-quot (+ x y) y) 1)))

;; tryone
;; 9 -2 => -4
;; 7 -2 => -3
;; 5 -2 => -2
;; 3 -2 => -1
;; 1 -2 => 0

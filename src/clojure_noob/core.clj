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

(defn my-mod
  ;; hasil bagi x oleh y
  [x y]
  (let [x (mutlak x)]
    (cond
      (and (< x (mutlak y)) (neg? y)) (- x)
      (and (< x (mutlak y)) (pos? y)) x
      (neg? y) (my-mod (+ x y) y)
      :else (my-mod (- x y) y))))

(defn my-inc
  [x]
  (+ x 1))

(defn my-dec
  [x]
  (- x 1))

;; take drop zipmap map take-while drop-while

(defn my-take
  ;; ambil x sejumlah m
  [m [x & xs :as lst]]
  (cond
    (<= m 0) '()
    (empty? lst) '()
    :else (cons x (my-take (my-dec m) xs))))

;; tryone
;; 2 [1 2 3 4 5]
;; 1 (1 [2 3 4 5])
;; 2 (0 [3 4 5])
;; '()

(defn my-drop
  ;; keluarin x sejumlah m
  [m [x & xs :as lst]]
  (cond
    (empty? lst) '()
    (<= m 0) lst
    :else (my-drop (my-dec m) xs)))

(defn my-zipmap
  [[x & xs :as xst] [y & ys :as yst]]
  (cond
    (or (empty? xst) (empty? yst)) {}
    :else (assoc (my-zipmap xs ys) x y)))


;; Clojure basic part three

(defn sum 
  ;; nambahin semua
  [[x & xs]]
  (if x
    (+' x (sum xs))
    0))

(defn sum'
  ;; recur gunain loop & recur
  [lst]
  (loop [[x & xs] lst
         res 0]
    (if x
      (recur xs (+ res x))
      res)))

(defn iter-prime
  ;; fungsi tambahan untuk cek prime
  [x y]
  (cond
    (= x y) true
    (zero? (rem x y)) false
    :else (iter-prime x (my-inc y))))

(defn prime?
  ;; cek prime kah?
  [x]
  (cond
    (<= x 1) false
    (= x 2) true
    :else (iter-prime x 2)))

(defn prime?2
  ;; cek prime kah?2
  [x]
  (let [iter (fn iter
               [y]
               (cond
                 (= x y) true
                 (zero? (rem x y)) false
                 :else (iter (my-inc y))))]
    (cond
      (<= x 1) false
      (= x 2) true
      :else (iter 2))))

(defn prime?3
  ;; cek prime kah?4 longkap bilangan genap
  [x]
  (let [iter (fn iter
               [y]
               (cond
                 (= x y) true
                 (zero? (rem x y)) false
                 :else (iter (+ y 2))))]
    (cond
      (<= x 1) false
      (= x 2) true
      (even? x) false
      :else (iter 3))))

(defn prime?4
  ;; cek prime kah?4 cek sampe akarnya ajah :v 
  [x]
  (let [sqrt-x (Math/sqrt x)
        iter (fn iter
               [y]
               (cond
                 (> y sqrt-x) true
                 (zero? (rem x y)) false
                 :else (iter (+ y 2))))]
    (cond
      (<= x 1) false
      (= x 2) true
      (even? x) false
      :else (iter 3))))


;; Clojure basic part four
;; => higher order fucntions ++ list comprehensions

(defn folding
  ;; same as reduce
  [f [x & xs]]
  (if x
    (f x (folding f xs))
    (f)))

(defn f-in-semua
  ;; same as map
  [f [x & xs]]
  (if x
    (cons (f x) (f-in-semua f xs))
    []))

(defn square
  ;; x^2
  [x]
  (* x x))

(defn prime?5
  ;; cek prime number
  [x]
  (->> (range 2 (inc (int (Math/sqrt x))))
       (every? #(pos? (rem x %)))))


(defn fib-lst
  ;; my fibonacci list
  [x]
  (let [fib (fn fib
              [x]
              (cond
               (= x 1) 1
               (= x 2) 1
               :else (+ (fib (- x 1)) (fib (- x 2)))))]
    (cond
     (= x 0) '()
     :else (conj (fib-lst (- x 1)) (fib x)))))

(defn jarlax-fib
  [x]
  (take x (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))))


;; Clojure basic part five
;; List comprehension

(defn foo-one 
  [x]
  (for [i (range x)
        j (range i x)]
    [i j]))


;; 4clojure.com

(defn my-reverse
  ;; reverse a list/vector
  [[x & xs]]
  (if x
    (conj (my-reverse xs) x)
    []))

(defn pal
  [[x & xs]]
  (cond
    (or (and x (empty? xs))
        (= x (last xs))) true
    (= x (last xs)) (pal (take (- (count xs) 1) xs))
    :else false))

(defn my-max
  [& xs]
  (->> xs
       (sort)
       (last)))

(def my-max' #(last (sort %&)))

(defn tcapt
  [[x & xs :as xst]]
  (let [wrd "HLOWRDAZ"
        taker (fn taker
                [m [y & ys]]
                (cond
                  (empty? wrd) '()
                  (= m (first wrd)) m
                  :else (taker (rest wrd))))]
    (cond
      (empty? xst) '()
      :else (cons (taker x wrd) (tcapt xs)))))

(defn tcap
  [[x & xs :as xst]]
  (let [seto (set "HLOWRDAZ")]
    (cond
      (empty? xst) ""
      (not= nil (seto x)) (cons x (tcap xs))
      :else (tcap xs))))

(defn compress
  [[x & xs :as xst]]
  (cond
    (empty? xst) '()
    :else (cons x (compress (drop-while #(= x %) xs)))))

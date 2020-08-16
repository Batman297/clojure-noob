(ns clojure-noob.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def mylist '(1 2 3 4 5 6 7 8 9 10))

(def myvec [1 2 3 4 5 6 7 8 9 10])

(def myset #{1 2 3 4 5 6 7 8 9 10})

(def mymap {:a 1 :b 2 :c 3 :d 4 :e 5})

(def person {:nama "denda" :umur "muda" :alamat "jauh banget"})

(def mykeylist '(:a :b :c :d))

(def mykeyvec [:a :b :c :d])

(defn square 
  [x] 
  (* x x))

;; ini comment gk bakal di evaluate


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

;; rumus kecap

(defn kecap
  [a b c]
  (let [adet (Math/sqrt (- (* b b) (* 4 a c)))]
    [(/ (- (- b) adet) (* 2 a))
     (/ (+ (- b) adet) (* 2 a))]))

(defn ngasal
  [x]
  (let [a (* x x)]
    (let [b (* a 2)]
      (* a b x))))


;; create functions
(defn sum
  [lst]
  (if (empty? lst)
    0
    (+ (first lst) (sum (rest lst)))))

(defn product
  [lst]
  (if (empty? lst)
    1
    (* (first lst) (product (rest lst)))))

(defn drop'
  [m lst]
  (cond
    (zero? m) lst
    (empty? lst) '()
    :else (drop' (dec m) (rest lst))))

(defn fibo
  [x]
  (case x
    1 0
    2 1
    (+ (fibo (- x 1)) (fibo (- x 2)))))

(defn fibo-lst
  [m n i]
  (cond
    (zero? i) '()
    (zero? (rem m 2)) (cons m (fibo-lst n (+ m n) (dec i)))
    :else (fibo-lst n (+ m n) (dec i))))

(defn take'
  [m [x & xs :as lst]]
  (cond
    (zero? m) '()
    (empty? lst) '()
    :else (cons x (take' (dec m) xs))))

;; projecteuler problem 1
(defn prob1
  [[x & xs :as lst]]
  (cond 
    (empty? lst) '()
    (= 1 (count lst)) (list x)
    (or (zero? (rem x 3)) (zero? (rem x 5))) (cons x (prob1 xs))
    :else (prob1 xs)))

;; next exercise
;; fibo, map, reduce, filter, keep,
;; zipmap, merge, assoc, dissoc, dll

(defn fibonacci
  ;; fast fibonacci
  [x]
  (loop [p x
         q 0
         r 1
         result []]
    (if (> p 0)
      (recur (dec p) r (+ q r) (conj result q))
      (last result))))

(defn prime?
  [x]
  (cond
    (< x 1) false
    1 false
    ))

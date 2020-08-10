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


;; create functions
(defn take'
  [m lst]
  (if (= m 0)
    nil
    (cons (first lst) (take' (dec m) (rest lst)))))

(defn sum'
  [lst]
  (if (empty? lst)
    0
    (+ (first lst) (sum' (rest lst)))))

(defn product'
  [lst]
  (if (empty? lst)
    1
    (* (first lst) (product' (rest lst)))))

(defn drop'
  [m lst]
  (if (= m 0)
    lst
    (drop' (dec m) (rest lst))))

;; haven't created fibonaci



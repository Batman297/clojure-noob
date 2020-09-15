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

;; tryone
;; fak 4
;; fak 4 * fak 3 => 4 * 3
;; fak 3 * fak 2 => 3 * 2
;; fak 2 * fak 1 => 2 * 1
;; fak 1 => 1

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

;; Clojure basic five
;; list comprehension (for)

(defn foo-one [n]
  (for [i (range n)] (* i i)))


;; Clojure for the Brave and True
;; learn the ultimate language and become a better programmer

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

(def severity :mild)

(def error-message "OH GOD! IT'S A DISASTER! WE'RE ")

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))

(def name "Chewbacca")

(defn too-enthusiastic
   "Return a cheer that might be a bit too enthusiastic"
   [name]
   (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
  "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(defn no-params
  []
  "I take no parameters!")
(defn one-param
  [x]
  (str "I take one parameter: " x))
(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smoosh them "
  "together to spite you! " x y))

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
     (str "I " chop-type " chop " name "! Take that!"))
  ([name]
     (x-chop name "karate")))

(defn weird-arity
  ([]
     "Destiny dressed you this morning, my friend, and now Fear is
     trying to pull off your pants. If you give up, if you give in,
     you're gonna end up naked with Fear just standing there laughing
     at your dangling unmentionables! - the Tick")
  ([number]
     (inc number)))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(defn my-first
  [[first-thing]] ; Notice that first-thing is within a vector
  first-thing)

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(defn announce-treasure-location2
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(defn receive-treasure-location
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")

(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(def my-special-multiplier (fn [x] (* x 3)))

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

(defn recursive-printer
  ([]
     (recursive-printer 0))
  ([iteration]
     (println iteration)
     (if (> iteration 3)
       (println "Goodbye!")
       (recursive-printer (inc iteration)))))

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn hit-the-part
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

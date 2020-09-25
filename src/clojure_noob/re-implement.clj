(ns reip.core)

;; ------------------------------
;; numbers
;; ------------------------------

;; arithmetic:
;; +
;; -
;; *
;; /
;; quot
(defn mutlak
  [x]
  (if (neg? x)
    (- x)
    x))

(defn my-quot
  ;; blm kelar nih
  [x y]
  (* x y))

;; rem
;; mod
;; inc
;; dec
;; max
;; min
;; with-precision
;; denominator
;; rand
;; rand-int

;; compare:
;; =
;; ==
;; not=
;; <
;; >
;; <=
;; >=

;; bitwise operations:
;; bit-and
;; bit-or
;; bit-xor
;; bit-flip
;; bit-not
;; bit-and-not
;; bit-clear
;; bit-set
;; bit-shift-left
;; bit-shift-right
;; bit-test

;; cast:
;; byte
;; short
;; int
;; long
;; float
;; double
;; bigint
;; bigdec
;; num
;; rationalize

;; test:
;; identical?
;; zero?
;; pos?
;; neg?
;; even?
;; odd?
;; number?
;; ratio?
;; rational?
;; integer?
;; int?
;; pos-int?
;; nat-int?
;; decimal?
;; big-dec?
;; float?
;; double?


;; ------------------------------
;; booleans
;; ------------------------------

;; test:
;; nil?
;; true?
;; false?

;; cast:
;; boolean


;; ------------------------------
;; symbols / keywords
;; ------------------------------

;; create:
;; keyword
;; symbol

;; use:
;; name
;; intern
;; namespace

;; test:
;; keyword?
;; symbol?
;; simple-keyword?
;; simple-symbol?
;; simple-ident?
;; quilfied-keyword?
;; qualified-symbol?
;; qualified-ident?


;; ------------------------------
;; strings / characters
;; ------------------------------

;; create:
;; str
;; print-str
;; println-str
;; pr-str
;; prn-str
;; with-out-str

;; use:
;; count
;; get
;; subs
;; format

;; cast/test:
;; char
;; char?
;; string?


;; ------------------------------
;; regular expressions
;; ------------------------------

;; create
;; re-pattern
;; re-matcher

;; use
;; re-find
;; re-matches
;; re-seq
;; re-groups


;; ------------------------------
;; flow control
;; ------------------------------

;; boolean:
;; not
;; and
;; or

;; normal:
;; let
;; if
;; if-not
;; if-let
;; if-some
;; when
;; when-not
;; when-let
;; when-first
;; when-some
;; cond
;; condp
;; cond->
;; cond->>
;; some->
;; some->>
;; as->
;; case
;; do
;; eval
;; loop
;; recur
;; trampoline
;; while

;; exceptional:
;; try
;; catch
;; finally
;; throw
;; assert

;; delay:
;; delay
;; delay?
;; deref
;; force

;; function based:
;; repeatedly
;; iterate

;; sequence based:
;; dotimes
;; doseq
;; for

;; laziness:
;; lazy-seq
;; lazy-cat
;; doall
;; dorun


;; ------------------------------
;; type inspection
;; ------------------------------

;; clojure types:
;; type
;; extends?
;; satisfies?

;; java types:
;; class
;; bases
;; supers
;; class?
;; intance?
;; isa?
;; cast


;; ------------------------------
;; concurrency
;; ------------------------------

;; general:
;; deref
;; get-validator
;; set-validator!

;; atoms:
;; atom
;; swap!
;; rest!
;; compare-and-set

;; refs:
;; ref
;; sync
;; dosync
;; ref-set
;; alter
;; commute
;; ensure
;; io!
;; ref-history-count
;; ref-max-history
;; ref-min-history

;; agents:
;; agent
;; send
;; send-off
;; await
;; await-for
;; agent-error
;; restart-agent
;; shutdown-agents
;; *agent*
;; agent-errors
;; error-handler
;; set-error-handler!
;; error-mode
;; set-error-mode!
;; release-pending-sends

;; futures:
;; future
;; future-call
;; future-done?
;; future-cancel
;; future-cancelled?
;; future?

;; volatiles:
;; volatile!
;; vswap!
;; vreset!

;; thread local values:
;; bound-fn
;; bound-fn*
;; get-thread-bindings
;; push-thread-bindings
;; pop-thread-bindings
;; thread-bound?

;; misc:
;; locking
;; pcalls
;; pmap
;; seque
;; promise
;; deliver
;; add-watch
;; remove-watch


;; ------------------------------
;; general
;; ------------------------------

;; create:
;; fn
;; defn
;; defn-
;; definline
;; identity
;; constantly
;; memfn
;; comp
;; complement
;; comparator
;; fnil
;; partial
;; juxt
;; memoize
;; some-fn
;; every-pred

;; call:
;; ->
;; ->>
;; apply

;; test:
;; fn?
;; ifn?

;; misc:
;; compare
;; hash


;; ------------------------------
;; numbers
;; ------------------------------

;; create:
;; defmulti
;; defmethod

;; inspect and modify:
;; get-method
;; methods
;; prefer-method
;; prefers
;; remove-method
;; remove-all-methods


;; ------------------------------
;; macros
;; ------------------------------

;; create:
;; defmacro
;; macroexpand
;; macroexpand-1
;; gensym


;; ------------------------------
;; java interop
;; ------------------------------

;; objects:
;; doto
;; ..
;; set!

;; array creation:
;; make-array
;; object-array
;; boolean-array
;; byte-array
;; char-array
;; short-array
;; int-array
;; long-array
;; float-array
;; double-array
;; aclone
;; to-array
;; to-array-2d
;; into-array

;; array use:
;; aget
;; aset
;; aset-boolean
;; aset-char
;; aset-byte
;; aset-int
;; aset-long
;; aset-short
;; aset-float
;; aset-double
;; alength
;; amap
;; areduce

;; casting:
;; booleans
;; bytes
;; chars
;; ints
;; shorts
;; longs
;; floats
;; doubles


;; ------------------------------
;; proxies
;; ------------------------------

;; create:
;; proxy
;; get-proxy-class
;; construct-proxy
;; init-proxy

;; misc:
;; proxy-mappings
;; proxy-super
;; update-proxy


;; ------------------------------
;; collections
;; ------------------------------

;; generic operations:
;; count
;; empty
;; not-empy
;; into
;; conj

;; content tests:
;; contains?
;; distinct?
;; empty?
;; every?
;; not-every?
;; some
;; not-any?

;; capabilities:
;; sequential?
;; associative?
;; sorted?
;; counted?
;; reversible?
;; seqable?

;; type tests:
;; coll?
;; seq?
;; vector?
;; list?
;; map?
;; set?


;; ------------------------------
;; vectors
;; ------------------------------

;; create:
;; vec
;; vector
;; vector-of

;; use:
;; conj
;; peek
;; pop
;; first
;; rest


;; ------------------------------
;; maps
;; ------------------------------

;; create:
;; hash-map
;; array-map
;; zipmap
;; sorted-map
;; sorted-map-by
;; bean
;; frequencies

;; use:
;; assoc
;; assoc-in
;; dissoc
;; find
;; key
;; val
;; keys
;; vals
;; get
;; get-in
;; update
;; select-keys
;; merge
;; merge-with
;; reduce-kv

;; use (sorted collections):
;; rseq
;; subseq
;; rsubseq


;; ------------------------------
;; sets
;; ------------------------------

;; create:
;; hash-set
;; set
;; sorted-set
;; sorted-set-by

;; use:
;; conj
;; disj
;; get


;; ------------------------------
;; structs
;; ------------------------------

;; create:
;; defstruct
;; create-struct
;; struct
;; struct-map
;; accessor

;; use:
;; get
;; assoc


;; ------------------------------
;; sequences
;; ------------------------------

;; create:
;; seq
;; sequence
;; eduction
;; repeat
;; replicate
;; range
;; repeatedly
;; iterate
;; lazy-seq
;; lazy-cat
;; cycle
;; interleave
;; interpose
;; tree-seq
;; xml-seq
;; enumeration-seq
;; iterator-seq
;; file-seq
;; line-seq
;; resultset-seq

;; use:
;; first
;; second
;; last
;; rest
;; next
;; ffirst
;; nfrist
;; fnext
;; nnext
;; nth
;; nthnext
;; nthrest
;; rand-nth
;; butlast
;; take
;; take-last
;; take-nth
;; take-while
;; drop
;; drop-last
;; drop-while

;; use (modification):
;; conj
;; concat
;; distinct
;; group-by
;; partition
;; partition-all
;; partition-by
;; split-at
;; split-with
;; filter
;; filterv
;; remove
;; replace
;; shuffle
;; random-sample
;; flatten
;; sort
;; sort-by
;; reverse
;; dedupe

;; use (iteration):
;; for
;; doseq
;; map
;; mapv
;; map-indexed
;; keep
;; keep-indexed
;; mapcat
;; reduce
;; reductions
;; transduce
;; max-key
;; min-key
;; doall
;; dorun


;; ------------------------------
;; transients
;; ------------------------------

;; create:
;; transient
;; persistent!

;; use (general):
;; conj!
;; pop!
;; assoc!
;; dissoc!
;; disj!


;; ------------------------------
;; variables
;; ------------------------------

;; create:
;; def
;; defonce
;; intern
;; declare

;; use:
;; set!
;; alter-var-root
;; binding
;; with-bindings
;; with-bindings*
;; with-local-vars
;; letfn
;; gensym

;; inspect:
;; var
;; find-var
;; var-get
;; var?
;; bound?
;; resolve
;; ns-resolve
;; special-symbol?


;; ------------------------------
;; namespaces
;; ------------------------------

;; create and delete:
;; ns
;; create-ns
;; remove-ns

;; inspect:
;; *ns*
;; ns-name
;; all-ns
;; the-ns
;; find-ns
;; ns-publics
;; ns-interns
;; ns-refers
;; ns-aliasses
;; ns-imports
;; ns-map

;; use:
;; in-ns
;; ns-resolve
;; ns-unalias
;; ns-unmap
;; alias

;; misc:
;; namespace-munge


;; ------------------------------
;; user defined types
;; ------------------------------

;; general:
;; defprotocol
;; defrecord
;; deftype
;; reify
;; extend
;; extend-protocol
;; extend-type
;; extenders


;; ------------------------------
;; metadata
;; ------------------------------

;; general:
;; meta
;; with-meta
;; vary-meta
;; reset-meta!
;; alter-meta!


;; ------------------------------
;; require or import
;; ------------------------------

;; general:
;; use
;; require
;; import
;; refer-clojure
;; refer


;; ------------------------------
;; code
;; ------------------------------

;; general:
;; *compile-files*
;; *compile-path*
;; *file*
;; *warn-on-reflection*
;; compile
;; load
;; load-file
;; load-reader
;; load-string
;; read
;; read-string
;; gen-class
;; gen-interface
;; loaded-libs
;; test


;; ------------------------------
;; io
;; ------------------------------

;; general:
;; *in*
;; *out*
;; *err*
;; print
;; printf
;; println
;; pr
;; prn
;; print-str
;; println-str
;; pr-str
;; prn-str
;; newline
;; flush
;; read-line
;; slurp
;; spit
;; with-in-str
;; with-out-str
;; with-open


;; ------------------------------
;; repl
;; ------------------------------

;; general:
;; *1
;; *2
;; *3
;; *e
;; *print-dup*
;; *print-length*
;; *print-level*
;; *print-meta*
;; *print-readably*


;; ------------------------------
;; misc
;; ------------------------------

;; general:
;; *clojure-version*
;; clojure-version
;; *command-line-args*
;; time

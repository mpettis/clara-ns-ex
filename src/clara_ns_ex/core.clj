(ns clara-ns-ex.core
  (:require [clara.rules :refer :all]))


;;; Facts are in clara-ns-ex.facts ns
(defrecord Myfact [theval])

(def facts 
  [(->Myfact 0)
   (->Myfact 1)
   (->Myfact 2)
   (->Myfact 3)
   (->Myfact 4)])

;; Rules
(defrecord Rulefail [theval])

(defrule rule-fail
  "Rule that checks for failure."
  [Myfact (= ?theval theval)]
  [:test (> ?theval 2)]
  =>
  (insert! (->Rulefail ?theval)))


;; Queries
(defquery get-rulefail
  "Get failed rules"
  []
  [?rulefail <- Rulefail])


;;; Rules are in clara-ns-ex.rules ns
;;; Queries are in clara-ns-ex.queries
(let [init-sess (mk-session 'clara-ns-ex.core)
      fact-sess (insert-all init-sess facts)]
  (-> fact-sess
      fire-rules
      (query get-rulefail)))


(ns clara-ns-ex.rules
  (:require [clara.rules :refer :all]))


(defrecord Rulefail [theval])

(defrule rule-fail
  "Rule that checks for failure."
  [Myfact (= ?theval theval)]
  [:test (> ?theval 2)]
  =>
  (insert! (->Rulefail ?theval)))


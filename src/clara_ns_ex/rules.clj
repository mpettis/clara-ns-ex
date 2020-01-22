(ns clara-ns-ex.rules
  (:require [clara.rules :refer :all]
            [clara-ns-ex.facts]
            )
  (:import [clara_ns_ex.facts Myfact]
           ))



(defrecord Rulefail [theval])

(defrule rule-fail
  "Rule that checks for failure."
  [Myfact (= ?theval theval)]
  [:test (> ?theval 2)]
  =>
  (insert! (->Rulefail ?theval)))


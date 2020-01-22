(ns clara-ns-ex.rules
  "Define session rules, to be imported to core."
  (:require 
    [clara-ns-ex.facts]
    [clara.rules :refer :all])
  (:import 
    [clara_ns_ex.facts Myfact]))



(defrecord Rulefail [theval])

(defrule rule-fail
  "Rule that checks for failure."
  [Myfact (= ?theval theval)]
  [:test (> ?theval 2)]
  =>
  (insert! (->Rulefail ?theval)))


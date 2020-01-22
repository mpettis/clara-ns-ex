(ns clara-ns-ex.facts)

;;; Fact defrecord
(defrecord Myfact [theval])

;;; Fact records
(def facts 
  [(clara-ns-ex.facts/->Myfact 0)
   (clara-ns-ex.facts/->Myfact 1)
   (clara-ns-ex.facts/->Myfact 2)
   (clara-ns-ex.facts/->Myfact 3)
   (clara-ns-ex.facts/->Myfact 4)])


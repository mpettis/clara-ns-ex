(ns clara-ns-ex.core
  (:require [clara.rules :refer :all]
            [clara-ns-ex.facts :refer :all]
            [clara-ns-ex.rules :refer :all]
            [clara-ns-ex.queries :refer :all]
            )
  (:import [clara_ns_ex.facts Myfact]
           [clara_ns_ex.rules Rulefail]
           ))


;;; Facts are in clara-ns-ex.facts ns
;;; Rules are in clara-ns-ex.rules ns
;;; Queries are in clara-ns-ex.queries
(let [init-sess (mk-session 'clara-ns-ex.core 'clara-ns-ex.rules 'clara-ns-ex.queries)
      fact-sess (insert-all init-sess clara-ns-ex.facts/facts)]
  (-> fact-sess
      fire-rules
      (query clara-ns-ex.queries/get-rulefail)))


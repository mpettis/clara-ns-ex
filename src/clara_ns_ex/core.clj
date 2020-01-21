(ns clara-ns-ex.core
  (:require [clara.rules :refer :all])
  (:require [clara-ns-ex.facts :refer :all])
  (:require [clara-ns-ex.rules :refer :all])
  (:require [clara-ns-ex.queries :refer :all]))


;;; Facts are in clara-ns-ex.facts ns
;;; Rules are in clara-ns-ex.rules ns
;;; Queries are in clara-ns-ex.queries
(let [init-sess (mk-session 'clara-ns-ex.core)
      rules-sess (insert init-sess rule-fail)
      query-sess (insert rules-sess get-rulefail)
      fact-sess (apply insert query-sess facts)]
  (-> fact-sess
      fire-rules
      (query get-rulefail)))


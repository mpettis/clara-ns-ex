(ns clara-ns-ex.core
  "Main ns to run the query from."
  (:require 
    [clara-ns-ex.facts :as facts]
    [clara-ns-ex.queries :refer [get-rulefail]]
    [clara.rules :refer :all]))


;;; Facts are in clara-ns-ex.facts ns
;;; Rules are in clara-ns-ex.rules ns
;;; Queries are in clara-ns-ex.queries
(let [init-sess (mk-session 'clara-ns-ex.rules 'clara-ns-ex.queries)
      fact-sess (insert-all init-sess facts/facts)]
  (-> fact-sess
      fire-rules
      (query get-rulefail)))


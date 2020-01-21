(ns clara-ns-ex.queries
  (:require [clara.rules :refer :all])
  (:require [clara-ns-ex.rules :refer :all]))

(defquery get-rulefail
  "Get failed rules"
  []
  [?rulefail <- Rulefail])


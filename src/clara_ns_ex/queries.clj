(ns clara-ns-ex.queries
  (:require [clara.rules :refer :all]
            [clara-ns-ex.rules]
            )
  (:import [clara_ns_ex.rules Rulefail]
           ))

(defquery get-rulefail
  "Get failed rules"
  []
  [?rulefail <- clara-ns-ex.rules/Rulefail])


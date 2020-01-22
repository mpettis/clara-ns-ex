(ns clara-ns-ex.queries
  "Define queries to use.  Needs some local record defs."
  (:require 
    [clara-ns-ex.rules]
    [clara.rules :refer :all])
  (:import 
    [clara_ns_ex.rules Rulefail]))

(defquery get-rulefail
  "Get failed rules"
  []
  [?rulefail <- Rulefail])


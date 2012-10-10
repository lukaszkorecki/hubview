(ns hubview.printer)
(require '[hubview.technicolor :as tc])

(defn print-event
  [event]
  (apply str
      (tc/taint :green (event :who))
      ":"
      (event :title)
      "\n"
      (tc/taint :blue (event :link))))

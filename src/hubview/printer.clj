(ns hubview.printer)
(require '[hubview.technicolor :as tc])

(defn print-event
  [event]
  (apply str
      (tc/taint :green (event :who))
      " : "
      (event :title)
      " "
      (tc/taint :yellow (str (event :date)))
      "\n"
      (tc/taint :blue (event :link))))

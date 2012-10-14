(ns hubview.core)
(require '[clojure.string :as st])
(require '[hubview.events :as ev])
(require '[hubview.printer :as p])

(defn -main
  [& args]
  (println args)
  ; get url from user, no error checking or cmd line arg parsing yet
  (def url (first args))

  ; latest on the bottom
  (def col (reverse (map p/print-event (ev/get-events-from url))))
  (println (st/join "\n\n" col)))

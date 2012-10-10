(ns hubview.core)
(require '[clojure.string :as st])
(require '[hubview.events :as ev])
(require '[hubview.printer :as p])

(defn -main
  []
  ; get url from user
  (def url
    "Read feed url from config file"
    (slurp (str (-> (java.io.File. "").getAbsolutePath) "/conf.clj")))

  (def col
    (map p/print-event (ev/get-events-from url)))
  (println (st/join "\n\n" col)))

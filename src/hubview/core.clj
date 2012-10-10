(ns hubview.core)
(require '[hubview.events :as ev])
(require '[hubview.printer :as p])

; get url from user
(def url
  "Read feed url from config file"
  (slurp (str (-> (java.io.File. "").getAbsolutePath) "/conf.clj")))

(p/print-event (first (ev/get-events-from url)))

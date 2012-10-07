(ns hubview.core)
(require 'hubview.events)

; get url from user
(def url
  "Read feed url from config file"
  (slurp (str (-> (java.io.File. "").getAbsolutePath) "/conf.clj")))

(first (hubview.events/get-events-from url))


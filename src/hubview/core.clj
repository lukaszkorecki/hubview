(ns hubview.core)
(require 'lib/feedparser-clj.core))

; get url from user
(def url (slurp (str (-> (java.io.File. "").getAbsolutePath) "~/conf.clj")))
; parse the feed
(def feed (feedparser-clj.core/parse-feed url))

(defn extract-event-data
  "Extracts information from single event from events feed"
  [event]
  ; helpers
  (defn title [event] (event :title ))
  (defn author [event] ((first (event :authors )) :name))
  (defn link [event] (event :link))

  {:who (author event)
  :link (link event)
  :title (title event)})

(first (map extract-event-data (feed :entries)))

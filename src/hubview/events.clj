(ns hubview.events)
(require 'lib/feedparser-clj.core)
(use '[clojure.string :only [replace-first trim]])

(defn get-feed-content
  [url]
  (feedparser-clj.core/parse-feed url))

(defn extract-event-data
  "Extracts information from single event from events feed"
  [event]
  ; helpers
  (def author ((first (event :authors )) :name))
  (def link   (event :link))
  (def created_at (event :published))
  (def title  (event :title ))

  {:who author
  :link  link
  :created_at created_at
  :title title})

(defn get-events-from
  "Get an event list for given url"
  [url]
  (map extract-event-data (:entries (get-feed-content url) )))

(ns hubview.events)
(require 'lib/feedparser-clj.core)
(use '[clojure.string :only [replace-first trim split join]])

(defn get-feed-content
  [url]
  (feedparser-clj.core/parse-feed url))

(defn extract-event-data
  "Extracts information from single event from events feed"
  [event]
  ; helpers
  (def author ((first (event :authors )) :name))
  (def link   (event :link))
  (def date (event :updated-date))

  ; title lookup
  (def v (split (event :title) #" "))
  (def title
    (if (= (first v) author)
      (join " " (rest v))
      (event :title)))

  ; used for has-map key
  (def id (event :id ))

  {:who author
  :link  link
  :date date
  :title title
  :id id })

(defn get-events-from
  "Get an event list for given url"
  [url]
  (map extract-event-data (:entries (get-feed-content url) )))

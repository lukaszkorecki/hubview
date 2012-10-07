(ns hubview.events)
(require 'lib/feedparser-clj.core)

(defn get-feed-content
  [url]
  (feedparser-clj.core/parse-feed url))

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

(defn get-events-from
  "Get an event list for given url"
  [url]
  (map extract-event-data (:entries (get-feed-content url) )))

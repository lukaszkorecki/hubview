(ns hubview.test.events
  (:use [hubview.events])
  (:use [clojure.test]))

(def an-event
  {:authors [{:name "a-name"}]
   :link "a link"
   :updated-date "a date"
   :id "an id"
   :title "a-name a title" })

(def extracted
  (hubview.events/extract-event-data an-event))

(deftest extracted-url
         (is (=  "a link" (extracted :link))))
(deftest extracted-authors
         (is (=  "a-name" (extracted :who))))
(deftest extracted-title
         (is (=  "a title" (extracted :title))))
(deftest extracted-date
         (is (=  "a date" (extracted :date))))
(deftest extracted-id
         (is (=  "an id" (extracted :id))))

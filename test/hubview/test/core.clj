(ns hubview.test.core
  (:use [hubview.core])
  (:use [clojure.test]))

(def an-event
  {:authors [{:name "a-name"}]
   :link "a link"
   :title "a title"
  })

(deftest extracting
         (is (= "yo" (:link (extract-event-data (an-event))))))

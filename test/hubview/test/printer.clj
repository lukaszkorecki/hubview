(ns hubview.test.printer
  (:use [hubview.printer])
  (:use [clojure.test]))

(def an-event
  {:who "user"
  :title "title"
  :link "http://somewhere.lol"
  :date "2001-11-11" })

(def printed
  (hubview.printer/print-event an-event))

(deftest printer-line
         (def res
           (re-find #".*user.*title.*2001-11-11.*\n.*http://somewhere.lol.*" printed))
         (is (not= res nil)))


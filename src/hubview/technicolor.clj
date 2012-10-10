(ns hubview.technicolor)
(defn taint
  "Colorize given string"
  [color string]
  ; reset sequence
  (def colorreset "\033[0m")
  ; ASCII escape codes
  ; I can bet that Java has this hidden somewhere
  (def colormap {
    :black  "\033[30m"
    :red  "\033[31m"
    :green  "\033[32m"
    :yellow  "\033[33m"
    :blue  "\033[34m"
    :magenta  "\033[35m"
    :cyan  "\033[36m"
    :white  "\033[37m"})
  (apply str (colormap color) string colorreset))

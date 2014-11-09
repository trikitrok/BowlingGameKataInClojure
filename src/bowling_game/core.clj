(ns bowling-game.core)

(defn score [rolls]
  (reduce + rolls))

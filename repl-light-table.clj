(def a-gutter-game (repeat 20 0))
(def a-no-spares-no-strikes-game (concat [1 6 4 5 3 1] (repeat 14 0)))
(def a-game-with-a-spare (concat [1 6 4 6 3 1] (repeat 14 0)))

(defn points [rolls]
  (reduce + rolls))

(def ten-points-in
  (comp (partial = 10) points (partial take)))

(def strike?
  (partial ten-points-in 1))

(def spare?
  (partial ten-points-in 2))

(strike? [3 4 0 5])

(strike? [6 4 0 5])

(strike? [10 0 5])

(defn first-frame [rolls]
  (if (strike? rolls) (take 1 rolls)
    (take 2 rolls)))

(first-frame [3 4 0 5])
(first-frame [6 4 0 5])
(first-frame [10 0 5])

(take 0 [1 2 3])

(defn bonus-rolls [rolls]
  (cond (strike? rolls) (drop 1 (take 3 rolls))
        (spare? rolls) (drop 2 (take 3 rolls))
        :else (take 0 rolls)))

(bonus-rolls [3 4 20 5])

(bonus-rolls [6 4 3 5])

(bonus-rolls [10 3 5])

(points
  (bonus-rolls [3 4 20 5]))

(points
 (bonus-rolls [6 4 3 5]))

(points
 (bonus-rolls [10 3 5]))

(defn rest-frames [rolls]
  (if (strike? rolls) (drop 1 rolls)
    (drop 2 rolls)))

(rest-frames [3 4 20 5])

(rest-frames [6 4 20 5])

(rest-frames [10 20 5])





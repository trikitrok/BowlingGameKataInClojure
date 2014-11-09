(ns bowling-game.core)

(defn points [rolls]
  (reduce + rolls))

(def ten-points-in
  (comp (partial = 10) points (partial take)))

(def strike?
  (partial ten-points-in 1))

(def spare?
  (partial ten-points-in 2))

(defn first-frame [rolls]
  (if (strike? rolls)
    (take 1 rolls)
    (take 2 rolls)))

(defn bonus-rolls [rolls]
  (cond (strike? rolls) (drop 1 (take 3 rolls))
        (spare? rolls) (drop 2 (take 3 rolls))
        :else (take 0 rolls)))

(defn rest-frames [rolls]
  (if (strike? rolls)
    (drop 1 rolls)
    (drop 2 rolls)))

(defn score-first-frame [rolls]
  (+ (points (first-frame rolls))
     (points (bonus-rolls rolls))))

(defn score [rolls]
  (if (empty? rolls)
    0
    (+ (score-first-frame rolls)
       (score (rest-frames rolls)))))

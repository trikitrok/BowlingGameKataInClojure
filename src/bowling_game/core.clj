(ns bowling-game.core)

(defn points [rolls]
  (reduce + rolls))

(defn first-frame [rolls]
  (take 2 rolls))

(defn spare? [rolls]
  (= 10 (points (first-frame rolls))))

(defn bonus-rolls [rolls]
  (cond (spare? rolls) (drop 2 (take 3 rolls))
        :else (take 0 rolls)))

(defn rest-frames [rolls]
  (drop 2 rolls))

(defn score-first-frame [rolls]
  (+ (points (first-frame rolls))
     (points (bonus-rolls rolls))))

(defn score [rolls]
  (if (empty? rolls)
    0
    (+ (score-first-frame rolls)
       (score (rest-frames rolls)))))

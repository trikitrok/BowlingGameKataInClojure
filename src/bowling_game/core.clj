(ns bowling-game.core)

(defn- points [rolls]
  (reduce + rolls))

(def ^:private ten-points? 
  (comp (partial = 10) points))

(def ^:private strike? 
  (comp ten-points? (partial take 1)))

(def ^:private spare?
  (comp ten-points? (partial take 2)))

(defn- first-frame [rolls]
  (if (strike? rolls)
    (take 1 rolls)
    (take 2 rolls)))

(defn- take-next [n rolls]
  (drop (- 3 n) (take 3 rolls)))

(defn- bonus-rolls [rolls]
  (cond (strike? rolls) (take-next 2 rolls)
        (spare? rolls) (take-next 1 rolls)
        :else (empty rolls)))

(defn- rest-frames [rolls]
  (if (strike? rolls)
    (drop 1 rolls)
    (drop 2 rolls)))

(defn- score-current-frame [rolls n]
  (if (> n 10)
    0
    (+ (points (first-frame rolls))
       (points (bonus-rolls rolls)))))

(defn- score-frames [rolls n]
  (if (empty? rolls)
    0
    (+ (score-current-frame rolls n)
       (score-frames (rest-frames rolls) (inc n)))))

(defn score [rolls]
  (score-frames rolls 1))

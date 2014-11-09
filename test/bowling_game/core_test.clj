(ns bowling-game.core-test
  (:use midje.sweet)
  (:use [bowling-game.core]))

(def a-gutter-game (repeat 20 0))
(def a-no-spares-no-strikes-game (concat [1 6 4 5 3 1] (repeat 14 0)))
(def a-game-with-spares (concat [4 6 4 5 3 1] (repeat 14 0)))

(facts "about bowling-game"
       (fact "it scores a game with no spins down"
             (score a-gutter-game) => 0)
       
       (fact "it scores a game with neither spares nor strikes"
             (score a-no-spares-no-strikes-game) => 20)
       
       (fact "it scores a game with a spare"
             (score a-game-with-spares) => 27))
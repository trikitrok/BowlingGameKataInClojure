(ns bowling-game.core-test
  (:use midje.sweet)
  (:use [bowling-game.core]))

(def a-gutter-game (repeat 20 0))

(facts "about bowling-game"
       (fact "it scores a game with no spins down"
             (score a-gutter-game) => 0))
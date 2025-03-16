# java-poker-implementation
Implementacja pokera w dwóch wariantach - gra i scenariusz. W pierwszym można wymienić karty natomiast w drugim ułożyć całą rękę.
# Przykłady
```
1 - gra
2 - scenariusz
2
Karty 1-10, 11-Jack, 12-Królowa, 13-Król, 14-As
Kolory 0-Heart, 1-Tile, 2-Clover, 3-Pike
Karty należy podawać w formacie:
<karta> <kolor>
Podaj karty gracza nr 1
14 0
4 1
3 2
2 3
1 2
Podaj karty gracza nr 2
10 0
7 1
6 2
5 3
4 0
[1♣, 2♠, 3♣, 4♦, Ace♥]
[4♥, 5♠, 6♣, 7♦, 10♥]
HighCard: 1♣, 2♠, 3♣, 4♦, Ace♥, , v=24, id: 1; 
HighCard: 4♥, 5♠, 6♣, 7♦, 10♥, , v=32, id: 2; 
Wygrał gracz nr 1
```
```
1 - gra
2 - scenariusz
1
Talia przed tasowaniem:
9♥ 10♥ Joker♥ Queen♥ King♥ Ace♥ 9♦ 10♦ Joker♦ Queen♦ King♦ Ace♦ 9♣ 10♣ Joker♣ Queen♣ King♣ Ace♣ 9♠ 10♠ Joker♠ Queen♠ King♠ Ace♠ 
Talia po tasowaniu:
Ace♦ Ace♠ Queen♥ 10♥ King♦ King♥ 9♠ King♠ 10♦ 9♦ 9♥ Joker♣ Queen♦ King♣ 10♠ Joker♦ Ace♥ 9♣ Queen♣ Joker♠ Ace♣ Queen♠ Joker♥ 10♣ 
Gracz 1: 9♠, 10♦, Queen♥, King♦, Ace♦, 
Ile kart wymienić?
0
Gracz 2: 9♦, 10♥, King♥, King♠, Ace♠, 
Ile kart wymienić?
0
[9♠, 10♦, Queen♥, King♦, Ace♦]
[9♦, 10♥, King♥, King♠, Ace♠]
Pair: King♥, King♠, , v=26, id: 2; 
HighCard: 9♠, 10♦, Queen♥, King♦, Ace♦, , v=58, id: 1; 
Wygrał gracz nr 2
```
```
1 - gra
2 - scenariusz
1
Talia przed tasowaniem:
9♥ 10♥ Joker♥ Queen♥ King♥ Ace♥ 9♦ 10♦ Joker♦ Queen♦ King♦ Ace♦ 9♣ 10♣ Joker♣ Queen♣ King♣ Ace♣ 9♠ 10♠ Joker♠ Queen♠ King♠ Ace♠ 
Talia po tasowaniu:
Joker♦ 9♦ 10♥ Ace♣ King♥ Ace♦ 9♠ 9♥ Queen♦ Queen♣ Joker♠ King♣ King♠ 9♣ Queen♥ Ace♠ 10♠ 10♣ 10♦ King♦ Joker♣ Ace♥ Queen♠ Joker♥ 
Gracz 1: 9♠, 10♥, Joker♦, Queen♦, King♥, 
Ile kart wymienić?
0
Gracz 2: 9♥, 9♦, Queen♣, Ace♦, Ace♣, 
Ile kart wymienić?
1
Podaj pozycję karty
2
Gracz 2: 9♥, Joker♠, Queen♣, Ace♦, Ace♣, 
[9♠, 10♥, Joker♦, Queen♦, King♥]
[9♥, Joker♠, Queen♣, Ace♦, Ace♣]
Straight: 9♠, 10♥, Joker♦, Queen♦, King♥, , v=55, id: 1; 
Pair: Ace♦, Ace♣, , v=28, id: 2; 
Wygrał gracz nr 1
```
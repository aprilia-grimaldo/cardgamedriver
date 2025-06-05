# Code review notes:

## Classes compare to README

All of the following code executes correctly what is intended in the original code:

- `Card` class
- `Deck` class
- `Hand` class (and correctly gets total value for Blackjack)

The `Blackjack` class also correctly executes what is described in the README file. 

The `LamarckianPoker` class did almost everything correctly.
Changes made:
 - changed the turn() method to use && instead of || 
this was done because the line originally would have continued if either of the players had less than 7 cards, even if the other one had 7 or more, we want the turn to continue if both of the players have less than 7 cards-- which is what is stated in the README file. The || means OR and the && is AND so both players must meet the requirements. 
- changed the discard pile from being a Deck object to a Hand object
this was doen because it is simpler and we do not needs all the methdos that come with Deck for the discard pile. In hindsightb this could also be a Queue but at this point in the course we hadn't covered that yet. The deck / stockpile could also be a Stack.
- changed the section where the discard pile cards are added back to the deck, to use .addAll method rather than for loop
this was doen to be faster/more efficent as all the cards should be added back and can use the addAll method rather than do each individual card.

After review; answering potential prompts on canvas asisgnment:
- seems like variables are type consistent
- does not seem like tehre are any redundancies to be addressed
- seemingly all comparisons are with ints not floats(will double check)
- all switch and if-elses cover all possible cases

## Lamarckian Poker error
Error from terminal (ran several times to get the error):
"Exception in thread "main" java.lang.IllegalArgumentException: bound must be positive
        at java.base/java.util.Random.nextInt(Random.java:322)
        at edu.guilford.LamarckianPoker.turn(LamarckianPoker.java:75)
        at edu.guilford.CardGameDriver.main(CardGameDriver.java:50)"

### Addressing the illegalargument error:
player1Hand.getCard(rand.nextInt(player1Hand.size())) throws the exception or an IndexOutofBoundsExeception if the player1Hand.size() is 0.
Or if we deal from an empty Deck ()?, thru deck.deal() and the deck happens to be empty, then this will thrwo teh exception.
To fix, changed the method so the player Hand size and the Deck size will be checked to see if they are empty before executing. 


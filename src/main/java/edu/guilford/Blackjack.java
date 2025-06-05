package edu.guilford;

public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    public Blackjack() {
        reset(true);
    }


    public Hand getPlayerHand() {
        return playerHand;
    }


    public Hand getDealerHand() {
        return dealerHand;
    }


    public Deck getDeck() {
        return deck;
    }


    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            deck.shuffle();
        }
    }

    // Overloaded reset method with no parameters
    // can call reset() with no arguments to always reset the deck
    // public void reset() {
    //     reset(true);
    // }


    public void deal() {
        playerHand = new Hand();
        dealerHand = new Hand();
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
    }

    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.addCard(deck.deal());
        }
        return playerHand.getTotalValue() <= 21;

    }

    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.deal());
        }
        return dealerHand.getTotalValue() <= 21;
    }

    // Override toString
    public String toString() {
        String result = "Player's Hand: \n";
        for (int i = 0; i < playerHand.size(); i++) {
            result += playerHand.getCard(i) + "\n";
        }
        result += "Player's Total: " + playerHand.getTotalValue() + "\n\n";
        result += "Dealer's Hand:\n";
        for (int i = 0; i < dealerHand.size(); i++) {
            result += dealerHand.getCard(i) + "\n";
        }
        result += "Dealer's Total: " + dealerHand.getTotalValue() + "\n\n";
        return result;
    }

}

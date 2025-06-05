package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class LamarckianPoker {
    private Hand player1Hand;
    private Hand player2Hand;
    private Hand pool;
    // *Review: changed the type of discard from Deck to Hand
    // private Deck discard;
    private Hand discard;
    private Deck deck;
    private Random rand = new Random();
    private int iTurn;

    public LamarckianPoker() {
        reset(true);
    }

    public Hand getPlayer1Hand() {
        return player1Hand;
    }

    public Hand getPlayer2Hand() {
        return player2Hand;
    }

    public Hand getPool() {
        return pool;
    }

    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            // *Review: original line:
            // discard = new Deck();
            // modified line:
            discard = new Hand();
            discard.reset();
            deck.shuffle();
        }
        iTurn = 0;
    }

    public void deal() {
        player1Hand = new Hand();
        player2Hand = new Hand();
        for (int iCard = 0; iCard < 4; iCard++) {
            player1Hand.addCard(deck.deal());
            player2Hand.addCard(deck.deal());
        }
    }

    public void makePool() {
        pool = new Hand();
        for (int iCard = 0; iCard < 4; iCard++) {
            pool.addCard(deck.deal());
        }
        // System.out.println("Deck size: " + deck.size());
    }

    // *Review: this method turn() should be a loop that continues until one player
    // has no cards left
    // Original turn() method
    public boolean turn() {
        // this is the original line:
        // if (player1Hand.size() < 7 || player2Hand.size() < 7) {

        // this is the modified line:
        // this checks if both players have less than 7 cards; changed the || to &&
        if (player1Hand.size() < 7 && player2Hand.size() < 7) {
            makePool();
            // System.out.println("Turn " + iTurn + "\n" + pool);
            Card player1Card = player1Hand.getCard(rand.nextInt(player1Hand.size()));
            Card player2Card = player2Hand.getCard(rand.nextInt(player2Hand.size()));
            Hand firstHand, secondHand;
            Card firstCard, secondCard;
            if (player1Card.getRank().ordinal() > player2Card.getRank().ordinal()) {
                firstHand = player1Hand;
                secondHand = player2Hand;
                firstCard = player1Card;
                secondCard = player2Card;
            } else if (player1Card.getRank().ordinal() < player2Card.getRank().ordinal()) {
                firstHand = player2Hand;
                secondHand = player1Hand;
                firstCard = player2Card;
                secondCard = player1Card;
            } else {
                if (player1Card.getSuit().ordinal() > player2Card.getSuit().ordinal()) {
                    firstHand = player1Hand;
                    secondHand = player2Hand;
                    firstCard = player1Card;
                    secondCard = player2Card;
                } else {
                    firstHand = player2Hand;
                    secondHand = player1Hand;
                    firstCard = player2Card;
                    secondCard = player1Card;
                }

            }

            ArrayList<Card> poolRemove = new ArrayList<Card>();

            for (Card poolCard : pool.getHand()) {
                if (firstCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        firstCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    firstHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            // Remove cards from pool
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            poolRemove.clear();
            pool.addCard(firstCard);
            firstHand.removeCard(firstCard);
            for (Card poolCard : pool.getHand()) {
                if (secondCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        secondCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    secondHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            pool.addCard(secondCard);
            secondHand.removeCard(secondCard);
            for (Card poolCard : pool.getHand()) {
                // *Review: this line was commented out in the original code
                // discard.getDeck().add(poolCard);
                // modified line:
                discard.addCard(poolCard); // add the card to the discard pile
            }
            pool.getHand().clear();
            // System.out.println("Discard\n" + discard.size());

            // *Review: these are the original lines:
            // if (deck.size() < 4) {
            // for (Card card : discard.getDeck()) {
            // deck.getDeck().add(card);
            // }
            // discard.clear();
            // // System.out.println("Discard\n" + discard.size());
            // }

            // this is the modified block:
            if (deck.size() < 4) {
                // deck.getDeck().addAll(discard.getDeck()); // add all the cards from the
                // discard pile
                // instead of using a loop to add each cards individually
                // discard.clear(); // empties the discard pile

                // *Review: changed the line to use the discard's hand instead of deck
                // this is the modified line with the addAll method:
                if (deck.size() < 4) {
                    deck.getDeck().addAll(discard.getHand());
                    discard.reset();
                }
            }
            iTurn++;

            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "\nPlayer 1: \n" + player1Hand + "\nPlayer 2: \n" + player2Hand + "\nPool: " + pool + "\n";
    }
}

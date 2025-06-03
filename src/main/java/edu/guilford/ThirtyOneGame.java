package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class ThirtyOneGame {

    // create a game with the following rules;
    // a collection of players, the deck, the discard pile and stockpile, and
    // probably a random number generator.

    // attributes
    private Hand player;
    private Hand dealer;
    private Deck deck;
    private Hand discardPile;
    private Hand stockPile;
    private Random random;

    // create an arraylist of players 2-16
    private ArrayList<player> players;

    // add a random number of players to the list
    private int numPlayers;

    // constructor
    public ThirtyOneGame() {
        player = new Hand();
        dealer = new Hand();
        deck = new Deck();
        discardPile = new Hand();
        stockPile = new Hand();
        random = new Random();
        
        players = new ArrayList<player>();
        numPlayers = 0;
    }

    // getters and setters
    public Hand getPlayer() {
        return player;
    }

    public void setPlayer(Hand player) {
        this.player = player;
    }

    public Hand getDealer() {
        return dealer;
    }

    public void setDealer(Hand dealer) {
        this.dealer = dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }


    public Hand getDiscardPile() {
        return discardPile;
    }
    public void setDiscardPile(Hand discardPile) {
        this.discardPile = discardPile;
    }
    public Hand getStockPile() {
        return stockPile;
    }
    public void setStockPile(Hand stockPile) {
        this.stockPile = stockPile;
    }
    public Random getRandom() {
        return random;
    }
    public void setRandom(Random random) {
        this.random = random;
    }
    public ArrayList<player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<player> players) {
        this.players = players;
    }
    public int getNumPlayers() {
        return numPlayers;
    }
    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }


    // methods
    // add a random number of players to the list
    public void addPlayers() {
        // cleaer
        // add random # players
        while (players.size() < 2 || players.size() > 16) {
            numPlayers = (int) (Math.random() * 15) + 2;
        }
    }

    // Shuffle the deck and deal 3 cards to each player
    // public void startGame() {
    //     deck.shuffle();
    //     for (player p : players) {
    //         for (int i = 0; i < 3; i++) {
    //             p.getHand().addCard(deck.deal());
    //         }
    //     }
    // }

    // Player decision method
    // public void playerDecision(player p) {
    //     // Example decision logic
    //     Card discardedCard = p.getHand().getCard(0); // Discard the first card
    //     p.getHand().removeCard(discardedCard);
    //     p.getHand().addCard(deck.deal()); // Pick up one card from the stockpile
    // }

    // Determine the round's loser and handle game restart
    // public void endRound() {
    //     player roundLoser = null;
    //     int lowestScore = Integer.MAX_VALUE;

    //     for (player p : players) {
    //         int score = p.getHand().getTotalValue();
    //         if (score < lowestScore) {
    //             lowestScore = score;
    //             roundLoser = p;
    //         }
    //     }

    //     if (roundLoser != null) {
    //         roundLoser.loseLife();
    //         if (roundLoser.getLives() == 0) {
    //             resetGame();
    //         }
    //     }
    // }

    // Reset the game
    // public void resetGame() {
    //     for (player p : players) {
    //         p.reset();
    //     }
    //     deck.clear();
    //     deck.build();
    //     deck.shuffle();
    //     startGame();
    // }

    public void reset() {
        player.reset();
        dealer.reset();
        deck.clear();
        deck.build();
        deck.shuffle();
    }

}

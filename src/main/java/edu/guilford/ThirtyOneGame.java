package edu.guilford;

import java.util.ArrayList;

public class ThirtyOneGame {


    // create a game with the following rules;
    // a collection of players, the deck, the discard pile and stockpile, and probably a random number generator.

    // attributes
    private Hand player;
    private Hand dealer;
    private Deck deck;

    // create a arraylist of players 2-16 
    private ArrayList<player> players;
    // add a random number of players ot the list
    private int numPlayers;


    // constructor
    public ThirtyOneGame() {
        deck = new Deck();
        deck.shuffle();
        player = new Hand();
        dealer = new Hand();
    
    }
    // getters and setters
    public Hand getPlayer() {
        return player;
    }
    public void setPlayer(Hand player) {
        this.player = player;
    }
    
    // methods
// add a random number of players to the list
    // while players.size() < 2 || players.size() > 16
    // add a random number of players to the list
    public void addPlayers() {
        while (players.size() < 2 || players.size() > 16) {
            numPlayers = (int) (Math.random() * 15) + 2;
        }
    }
    public void reset() {
        player.reset();
        dealer.reset();
        deck.clear();
        deck.build();
        deck.shuffle();
    }

}

package edu.guilford;

public class player <ArrayList> extends Hand {

    // attributes
    // hand and number of lives for the player
    private Hand hand;
    private int lives;

    // constructor
    public player() {
        hand = new Hand();
        lives = 3;
    }

    // getters and setters

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    // lose a life when the player has the lowest score in a round
    public void loseLife() {
        lives--;
    }

    // reset the player's hand and lives

    public void reset() {
        hand.reset();
        lives = 3;
    }

    // toString method

    public String toString() {
        return "Player [hand=" + hand + ", lives=" + lives + "]";
    }

}

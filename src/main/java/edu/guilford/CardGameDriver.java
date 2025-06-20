package edu.guilford;

public class CardGameDriver {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("==============================");
        System.out.println("------ Card Game Driver ------");
        System.out.println("==============================");
        System.out.println("------ Blackjack Game: ------");
        System.out.println("-----------------------------");
        
        final int NGAMES = 10000;
        int dealerWins = 0;
        int playerWins = 0;
        Blackjack game = new Blackjack();
        game.deal();

        int iGame = 0;
        while (iGame < NGAMES) {
            game.deal();
            if (game.getPlayerHand().getTotalValue() == 21) {
                playerWins++;
            } else if (game.getDealerHand().getTotalValue() == 21) {
                dealerWins++;
            } else {
                boolean playerResult = game.playerTurn();
                boolean dealerResult = game.dealerTurn();
                if (!playerResult) {
                    dealerWins++;
                } else if (!dealerResult) {
                    playerWins++;
                } else if (game.getPlayerHand().getTotalValue() < game.getDealerHand().getTotalValue()) {
                    dealerWins++;
                } else if (game.getPlayerHand().getTotalValue() > game.getDealerHand().getTotalValue()) {
                    playerWins++;
                }
            }
            if (game.getDeck().size() < 10) {
                game.reset(true);
            }

            iGame++;
        }
        System.out.println("Dealer wins: " + dealerWins);
        System.out.println("Player wins: " + playerWins);
        System.out.println("Pushes: " + (NGAMES - dealerWins - playerWins));

        System.out.println("==============================");
        System.out.println("Lamarckian Poker Game:");
        System.out.println("-----------------------------");
        System.out.println();
        LamarckianPoker lmpGame = new LamarckianPoker();
        lmpGame.deal();
        System.out.println("\nInitial Lamarckian hands\n" + lmpGame);

        boolean gameDone = false;
        while (!gameDone) {
        //    System.out.println(lmpGame);
            gameDone = !lmpGame.turn();
        }

        System.out.println("Final Lamarckian hands\n" + lmpGame);   

        System.out.println("==============================");

        // *Review: commented out the original Blackjack game loop
        // System.out.println(game);
        // int iGame = 0;
        // while (iGame < NGAMES) {
        //     game.deal();
        //     if (game.getPlayerHand().getTotalValue() == 21) {
        //         playerWins++;
        //     } else if (game.getDealerHand().getTotalValue() == 21) {
        //         dealerWins++;
        //     } else {
        //         boolean playerResult = game.playerTurn();
        //         boolean dealerResult = game.dealerTurn();
        //         if (!playerResult) {
        //             dealerWins++;
        //         } else if (!dealerResult) {
        //             playerWins++;
        //         } else if (game.getPlayerHand().getTotalValue() < game.getDealerHand().getTotalValue()) {
        //             dealerWins++;
        //         } else if (game.getPlayerHand().getTotalValue() > game.getDealerHand().getTotalValue()) {
        //             playerWins++;
        //         }
        //     }
        //     if (game.getDeck().size() < 10) {
        //         game.reset(true);
        //     }

        //     iGame++;
        // }
        // System.out.println("Dealer wins: " + dealerWins);
        // System.out.println("Player wins: " + playerWins);
        // System.out.println("Pushes: " + (NGAMES - dealerWins - playerWins));

        // LamarckianPoker lmpGame = new LamarckianPoker();
        // lmpGame.deal();
        // System.out.println("\nInitial Lamarckian hands\n" + lmpGame);

        // boolean gameDone = false;
        // while (!gameDone) {
        // //    System.out.println(lmpGame);
        //     gameDone = !lmpGame.turn();
        // }
  
        //System.out.println("First game:\n");
        // add javadoc comments??

    }
}
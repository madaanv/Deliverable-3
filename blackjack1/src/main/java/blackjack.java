

import java.util.ArrayList;
import java.util.Scanner;

public class blackjack {
    private static blackjack game;
    //array list players created
    private ArrayList<Person> players;
    private Deck deck;

    public blackjack() {
        initializeGame();
        dealCards();
        takeTurns();
        declareResult();
        playAgain();
    }

    public static void main(String[] args) {
        game = new blackjack();
    }

    private void initializeGame() {
        deck = new Deck();
        players = new ArrayList<Person>();
       //adds new player to array list from Player class object
        players.add(new Player());
        //adds dealer to array list from Dealer class object
        players.add(new Dealer());

        System.out.println("Welcome to a new Blackjack game!");
    }

    private void dealCards() {
        for (Person player : players) {
            deck.dealInitialCards(player);
            player.printCards(player.getName().equals("You"));
        }
    }

    private void takeTurns() {
        for (Person player: players) {
            boolean endOfTurn = false;
            while(!endOfTurn) {
                player.printCards(true);
                boolean hit = player.wantToHit();
                if (hit) {
                    deck.dealCard(player);
                    System.out.println(player.getName() + " drew a card.\n");
                    if (player.getTotal() > 21) {
                        endOfTurn = true;
                        System.out.println(player.getName() + " died.\n");
                    }
                } else {
                    endOfTurn = true;
                    System.out.println(player.getName() + " stayed.\n");
                }
            }
        }
    }

    private void declareResult() {
        byte highest = -1;
        byte topPlayer = -1;
        for (byte i = 0; i < players.size(); i++) {
            String name = players.get(i).getName();
            byte total = players.get(i).getTotal();

            System.out.println(name + (name.equals("You") ? " have " : " has ") + "a total of " + total + ".");

            if (total > highest && total <= 21) {
                highest = total;
                topPlayer = i;
            }
            if (total == highest && name.equals("The dealer")) {
                topPlayer = i;
            }
        }
        if (topPlayer == -1) {
            System.out.println("Everyone is dead. Nobody wins.");
        } else {
            System.out.println(players.get(topPlayer).getName() + " wins!");
        }
    }

    private void playAgain() {
        System.out.print("\nPlay again? \"y\" / \"n\": ");
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            String input = keyboard.next();
            if (input.equals("y")) {
                game = new blackjack();
            } else if (input.equals("n")) {
                System.exit(0);
            } else {
                System.out.print("Please type \"y\" or \"n\": ");
            }
        }
    }
}

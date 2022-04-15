/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinu
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private List<Card> cards;
    protected String name;
    protected byte total;

    public Person() {
        cards = new ArrayList<Card>();
        total = 0;
    }

    public Card receiveCard(Card card) {
        cards.add(card);
        total += card.getValue();
        return card;
    }

    public abstract boolean wantToHit();

    public byte getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public void printCards(boolean showAll) {
        System.out.print("\n" + name + (name == "You" ? " have a" : " has a") + (cards.get(0).getValue() == 8 || cards.get(0).getValue() == 11 ? "n " : " ") + cards.get(0).toString());
        for (int i = 1; i < cards.size(); i++) {
            if (showAll) {
                System.out.print(" and a" + (cards.get(i).getValue() == 8 || cards.get(i).getValue() == 11 ? "n " : " ") + cards.get(i).toString());
            } else {
                System.out.println(" and a hidden card.");
            }
        }
        if (showAll) {
            System.out.println(".\n" + name + (name == "You" ? "r" : "'s") + " total is " + total + ".");
        }
    }
}
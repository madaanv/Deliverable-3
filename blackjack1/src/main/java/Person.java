
import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    //array list of cards
    private List<Card> cards;
   //field variables with protected visibility
    protected String name;
    protected byte total;
    //constructor
    public Person() {
        cards = new ArrayList<Card>();
        total = 0;
    }

    public Card receiveCard(Card card) {
        cards.add(card);
        total += card.getValue();
        return card;
    }
     //abstract method, need to be executed in sub class
    public abstract boolean wantToHit();
    //getters
    public byte getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }
    // printCards method takes boolean parameter
    public void printCards(boolean showAll) {
        System.out.print("\n" + name + (name == "You" ? " have a" : " has a") + (cards.get(0).getValue() == 8 || cards.get(0).getValue() == 11 ? "n " : " ") + cards.get(0).toString());
       //for loop used here to print content of array
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

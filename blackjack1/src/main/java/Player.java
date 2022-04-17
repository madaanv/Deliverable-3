
/**
 *
 * This is Player class, sublclass of Person class
 */
import java.util.Scanner;

public class Player extends Person {
   //to take input from user scanner is used
    private Scanner keyboard;

    public Player() {
        //calls constructor from its super class
        super();
        name = "You";
        keyboard = new Scanner(System.in);
    }
    
    //this function returns boolean value
    public boolean wantToHit() {
        System.out.print("\nWould you like to \"hit\" or \"stay\": ");
        while (true) {
            String input = keyboard.next();
            if (input.equals("hit")) {
                return true;
            } else if (input.equals("stay")) {
                return false;
            } else {
                System.out.print("Type \"hit\" or \"stay\": ");
            }
        }
    }
}

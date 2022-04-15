/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinu
 */
import java.util.Scanner;

public class Player extends Person {
    private Scanner keyboard;

    public Player() {
        super();
        name = "You";
        keyboard = new Scanner(System.in);
    }

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

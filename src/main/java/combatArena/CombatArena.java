/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatArena;
import java.util.Scanner;

/**
 * Class presents combat two fighters in arena
 * launadaniel2@gmail.com
 * @author Laun 
 */
public class CombatArena {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Enter name of first player:");
        String playerOne = sc.nextLine();
        
        System.out.println("Enter name of second player:");
        String playerTwo = sc.nextLine();
        
        // Create dice
        Dice dice = new Dice(10);
        // Create first fighter
        Fighter player1 = new Fighter(playerOne, 100, 20, 10, dice);
        // Create second fighter
        Fighter player2 = new Witcher(playerTwo, 100, 20, 10, dice, 30, 25);
        // Create arena
        Arena arena = new Arena(player1, player2, dice);
        //  combat
        arena.combat();
    }
}

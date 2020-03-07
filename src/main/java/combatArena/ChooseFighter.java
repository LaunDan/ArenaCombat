/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatArena;
import java.util.Scanner;

/**
 *
 * @author Laun
 */
public class ChooseFighter {
    
    Scanner sc = new Scanner(System.in, "Windows-1250");
    public void chooseName(){
        System.out.println("Enter name of first player:");
        String PlayerOneName = sc.nextLine();
        System.out.println("Enter name of second player:");
        String PlayerTwoName = sc.nextLine();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatArena;

/**
 * Class presents arena.
 * launadaniel2@gmail.com
 * @author Laun
 */
public class Arena {

    private Fighter playerOne;
    private Fighter playerTwo;
    private Dice dice;

    /**
     * Arena with two figters and dice
     * @param playerOne
     * @param playerTwo
     * @param dice
     */
    public Arena(Fighter playerOne, Fighter playerTwo, Dice dice) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.dice = dice;
    }
    /**
     * draw prints headline Arena, also fighters hp and others stats
     */
    private void draw() {
        System.out.println(" _______  _______  _______  _        _______ \n" +
"(  ___  )(  ____ )(  ____ \\( (    /|(  ___  )\n" +
"| (   ) || (    )|| (    \\/|  \\  ( || (   ) |\n" +
"| (___) || (____)|| (__    |   \\ | || (___) |\n" +
"|  ___  ||     __)|  __)   | (\\ \\) ||  ___  |\n" +
"| (   ) || (\\ (   | (      | | \\   || (   ) |\n" +
"| )   ( || ) \\ \\__| (____/\\| )  \\  || )   ( |\n" +
"|/     \\||/   \\__/(_______/|/    )_)|/     \\|\n" +
"                                             ");
        System.out.println("Fighters: \n");
        printFighter(playerOne);
        System.out.println();
        printFighter(playerTwo);
        System.out.println();
    }
    
    /**
     * print message and make pause for drama
     * @param message 
     */
    private void writeMessage(String message) {
        System.out.println(message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println("Error, failed to put aside sleepy");
        }
    }
    /**
     * 
     * @param b 
     */
    private void printFighter(Fighter b) {
        System.out.println(b);
        System.out.print("Life: ");
        System.out.println(b.graphicLife());
        if (b instanceof Witcher) {
            System.out.print("Mana: ");
            System.out.println(((Witcher)b).graphicMana());
        }
    }
    /**
     * Combat between two players. 
     * printss greetings. presents fighters. Who attcack first in iteracion is choosen by dice
     * fighting till one of them die
     * prints who won
     */
    public void combat() {
        Fighter firstPlayer = playerOne;
        Fighter secondPlayer = playerTwo;
        System.out.println("Welcome in arena!");
        System.out.printf("Today will fight %s againts %s! \n\n", playerOne, playerTwo);
        System.out.println("So it begins!!!");
        
        while (firstPlayer.alive() && secondPlayer.alive()) {
            boolean startsPlayerTwo = (dice.throwed() <= dice.returnAmountWalls() / 2);
            if (startsPlayerTwo) {
                firstPlayer = playerTwo;
                secondPlayer = playerOne;
            }
            
            firstPlayer.attacking(secondPlayer);
            draw();
            writeMessage(firstPlayer.returnLastMessage());
            writeMessage(secondPlayer.returnLastMessage());
            if (secondPlayer.alive()) {
                secondPlayer.attacking(firstPlayer);
                draw();
                writeMessage(secondPlayer.returnLastMessage());
                writeMessage(firstPlayer.returnLastMessage());
            }
            System.out.println();
        }
        if (playerOne.alive()){
            System.out.printf("%s won!!", playerOne);
        } else {
            System.out.printf("%s won!!", playerTwo);
        }
    }
    
   
}

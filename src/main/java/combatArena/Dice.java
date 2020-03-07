/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatArena;

import java.util.Random;

/**
 * Class presents dice. 
 * launadaniel2@gmail.com
 * @author Laun
 */
public class Dice {

    /**
     * Generator of random numbers.
     */
    private Random random;
    /**
     * Numbers of walls
     */
    private int amountWalls;

    /**
     * Cube with 6 walls
     */
    public Dice() {
        amountWalls = 6;

        random = new Random();
    }

    /**
     * Cube with amountWalls walls
     *
     * @param amountWalls amount of walls
     */
    public Dice(int amountWalls) {
        this.amountWalls = amountWalls;

        random = new Random();
    }

    /**
     * Return amount of walls of dice
     *
     * @return Amount of walls of dice.
     */
    public int returnAmountWalls() {
        return amountWalls;
    }

    /**
     * Will throw dice
     *
     * @return Random number from 1 to amount of walls
     */
    public int throwed() {
        return random.nextInt(amountWalls) + 1;
    }

    /**
     * Return text about dice ("Cube with %d walls", amountWalls)
     *
     * @return Text about dice
     */
    @Override
    public String toString() {
        return String.format("Cube with %d walls", amountWalls);
    }
}

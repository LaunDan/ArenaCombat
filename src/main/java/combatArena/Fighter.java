/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatArena;

/**
 * Class presents fighter.
 * launadaniel2@gmail.com
 * @author Laun
 */
public class Fighter {

    /**
     * Name of fighter
     */
    protected String name;
    /**
     * Life in HP
     */
    protected int life;
    /**
     * Max life
     */
    protected int maxLife;
    /**
     * Attack in HP
     */
    protected int attack;
    /**
     * Defence in HP
     */
    protected int defence;
    /**
     * Instance of dice
     */
    protected Dice dice;
    /**
     * Messages for users
     */
    private String message;

    /**
     * Fighter with name, life, defence, attack and dice.
     *
     * @param name
     * @param life
     * @param attack
     * @param defence
     * @param dice
     */
    public Fighter(String name, int life, int attack, int defence, Dice dice) {
        this.name = name;
        this.life = life;
        this.maxLife = life;
        this.attack = attack;
        this.defence = defence;
        this.dice = dice;
    }

    /**
     * return true if is fighter alive and false if othervise
     *
     * @return true or false
     */
    public boolean alive() {
        return (life > 0);
    }

    /**
     * Make graphic pointer
     * @param current Current quantity
     * @param max Max quantity
     * @return String what looks like graph
     */
    protected String graphicPointer(int current, int max) {
        String s = "[";
        int total = 20;
        double amount = Math.round(((double) current / max) * total);
        if ((amount == 0) && (alive())) {
            amount = 1;
        }
        for (int i = 0; i < amount; i++) {
            s += "#";
        }
        s = String.format("%1$-" + (total + 1) + "s", s);
        s += "]";
        return s;
    }
    /**
     * Make graphic pointer presents life of fighter
     * @return String looks like graph
     */
    public String graphicLife(){
        return graphicPointer(life, maxLife);
    }

    /**
     * defence and life changing by injury injury is big as hit - (defence +
     * throw by dice) prints string about who get how much injury and if someone
     * die, othervise prints who fight off the attack
     *
     * @param hit
     */
    public void defenceYourself(int hit) {
        int injury = hit - (defence + dice.throwed());
        if (injury > 0) {
            life -= injury;
            message = String.format("%s get damage %s hp ", name, injury);
            if (life <= 0) {
                life = 0;
                message += "and die";
            }
        } else {
            message = String.format("%s fight off attack", name);
        }
        setMessage(message);
    }

    /**
     * Attack to the rival by hit witch is attack + throw dice prints message
     * about who attack about how much strong in hp calls
     * rival.defenceYourself(hit)
     *
     * @param rival
     */
    public void attacking(Fighter rival) {
        int hit = attack + dice.throwed();
        setMessage(String.format("%s attacking with hit about %s hp", name, hit));
        rival.defenceYourself(hit);
    }

    /**
     * Set message to private variable
     *
     * @param message
     */
    protected void setMessage(String message) {
        this.message = message;
    }

    /**
     * return message
     *
     * @return message
     */
    public String returnLastMessage() {
        return message;
    }

    /**
     * Write name of fighter
     *
     * @return name of fighter
     */
    @Override
    public String toString() {
        return name;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatArena;

/**
 * Class presents witcher. It's descendant from Class Fighter.
 * launadaniel2@gmail.com
 * @author Laun
 */
class Witcher extends Fighter {
    private int mana;
    private int maxMana;
    private int magicAttack;
    public Witcher(String name, int life, int attack, int defence, Dice dice, int mana, int magicAttack) {
        super(name, life, attack, defence, dice);
        this.mana = mana;
        this.maxMana = mana;
        this.magicAttack = magicAttack;
    }
    /**
     * Atack rival with magic if player have enough mana
     * @param rival avariable of rival
     */
    @Override
    public void attacking(Fighter rival) {
        if (mana < maxMana) {
            mana += 10;
            if (mana > maxMana) {
                mana = maxMana;
            }
            super.attacking(rival);
        } else {
            int hit = magicAttack + dice.throwed();
            setMessage(String.format("%S attacking with magic about %s hp", name, hit));
            rival.defenceYourself(hit);
            mana = 0;
        }
    }
    /**
     * return graph mana pointer
     * @return String looks like graphic pointer 
     */
    public String graphicMana(){
        return graphicPointer(mana, maxMana);
    }
}
   

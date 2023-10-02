package org.example;

public class Player extends Entity{

    public final int maxHealth = getHealth();
    private int healCount;

    public Player(int attack, int protection, int health) {
        super(attack, protection, health);
        healCount = 0;
    }

    public void heal(){
        if (healCount < 4 ){
            setHealth(maxHealth + (int)(maxHealth*0.3));
            healCount++;
        }
    }
}

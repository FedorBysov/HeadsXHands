package org.example;

public class Entity {
    private int attack;
    private int protection;
    private int health;
    private int damage;

    public Entity(int attack, int protection, int health) {
        this.attack = setAttack(attack);
        this.protection = setProtection(protection);
        this.health = health;
    }

    public int getProtection() {
        return protection;
    }

    public int setProtection(int protection) {
        if (protection < 1 || protection > 30) {
            throw new IllegalArgumentException("The Protection value is greater than 30 ");
        }
        return this.protection = protection;
    }

    public int getAttack() {
        return attack;
    }

    public int setAttack(int attack) {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("The Attack value is greater than 30 ");
        }
        return this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0 || health <= Integer.MAX_VALUE) {
            this.health = health;
        } else {
            throw new IllegalArgumentException("Health is less than 0 or out of range ");
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage >= 0 || damage <= Integer.MAX_VALUE) {
            this.damage = (int) (Math.random() * damage) + 1;
        } else {
            throw new IllegalArgumentException("Health is less than 0 or out of range ");
        }
    }

    public void attack(Entity anotherEntity) {
        if (getHealth() > 0) {
            int attackModifier = Math.abs(getAttack() - getProtection()) + 1;
            int numberOfCubes = Math.max(1, attackModifier);
            int totalDamage = 0;
            for (int i = 0; i < numberOfCubes; i++) {
                int cube = (int) (Math.random() * 6 + 1);
                if (cube >= 5) {
                    totalDamage += (int) (Math.random() * (getDamage() - 1)) + 1;
                }

            }
            anotherEntity.health -= totalDamage;
        }
    }
}

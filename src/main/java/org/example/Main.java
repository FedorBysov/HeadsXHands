package org.example;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(18, 24, 50);
        Monster goblin = new Monster(10, 6, 40);

        System.out.println("Player MAX HP: " + player.maxHealth);

        while (true) {
            if (player.getHealth() <= 0) {
                System.out.println("You died!");
                break;
            } else {
                System.out.println("PLAYER HP: " + player.getHealth());
                player.attack(goblin);
            }

            if (goblin.getHealth() <= 0) {
                System.out.println("You defeated the monster!");
                break;
            } else {
                System.out.println("MONSTER HP: " + goblin.getHealth());
                goblin.attack(player);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Player HP: " + player.getHealth());
        player.heal();
        System.out.println("Player HP: " + player.getHealth());
    }
}


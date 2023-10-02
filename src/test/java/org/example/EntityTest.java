package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EntityTest {

    @Test
    public void testSetHealth_withValidHealth_shouldSetHealth() {
        Entity entity = new Entity (10, 5, 100);

        entity.setHealth(50);

        assertEquals(50, entity.getHealth());
    }

    @Test
    public void testSetHealth_withNegativeHealth_shouldThrowIllegalArgumentException() {
        Entity entity = new Entity (10, 5, 100);

        assertThrows(IllegalArgumentException.class,() -> entity.setHealth(-2));
    }

    @Test
    public void testHeal_withValidHeal_shouldHealPlayer() {
        Player player = new Player (10, 5, 100);

        player.heal();

        assertEquals(130, player.getHealth());
    }

    @Test
    public void testHeal_withMaxHealCount_shouldThrowIllegalStateException() {
        Player player = new Player (10, 5, 100);

        for (int i = 0; i < 4; i++) {
            player.heal();
        }
        assertThrows(IllegalArgumentException.class, player::heal);
    }

}
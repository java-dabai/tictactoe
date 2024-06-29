package com.tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {



    private Player player = new Player('X');;



    // Test construction method
    @Test
    void testConstructorWithValidMarker() {
        // Positive test: Use valid marker characters
        Player validPlayer = new Player('O');
        assertEquals("The marker should be 'O'", 'O', validPlayer.getMarker());
    }

    // Test getMarker method
    @Test
    public void testGetMarkerWithValidPlayer() {
        // Positive test: Get a valid player tag
        assertEquals("The marker for player should be 'X'", 'X', player.getMarker());
    }





}

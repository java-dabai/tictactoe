package com.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.clear(); // Make sure the board is empty to start the test
    }

    // Test construction method
    @Test
    void testBoardConstructor() {
        // Front test: The board is initialized to 3x3 and all cells are Spaces
        char[][] expectedCells = new char[3][3];
        for (int i = 0; i < expectedCells.length; i++) {
            for (int j = 0; j < expectedCells[i].length; j++) {
                expectedCells[i][j] = ' ';
            }
        }
        assertArrayEquals(expectedCells, board.getCells());
    }

    // test isCellEmpty method
    @Test
    void testIsCellEmptyWithEmptyCell() {
        // Frontal test: Check empty cells
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmptyWithFilledCell() {
        // Reverse test: Checks the filled cells
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    // test place method
    @Test
    void testPlaceMarkerOnEmptyCell() {
        // Frontal test: Place a marker in an empty cell
        board.place(1, 1, 'O');
        assertEquals('O', board.getCells()[1][1]);
    }



    // test isFull method
    @Test
    void testIsFullWithEmptyCells() {
        // Negative test: The board is not empty
        assertFalse(board.isFull());
    }

    @Test
    void testIsFullWithAllCellsFilled() {
        // Positive test: The board is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    // test clear method
    @Test
    void testClearBoard() {
        // Positive test:  Clear the board
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    // test print method
    @Test
    void testPrintBoard() {
        // Positive test: Print the board
        board.place(0, 0, 'X');

    }
}

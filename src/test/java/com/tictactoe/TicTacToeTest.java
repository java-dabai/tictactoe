package com.tictactoe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TicTacToeTest {
    private TicTacToe ticTacToe;
    private Board board;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        player1 = new Player('X');
        player2 = new Player('O');
        board = mock(Board.class);
        ticTacToe = new TicTacToe() {

            public Board getBoard() {
                return board;
            }

            @Override
            public char getCurrentPlayerMarker() {
                return super.currentPlayer.getMarker();
            }
        };
        ticTacToe.player1 = player1;
        ticTacToe.player2 = player2;
        ticTacToe.currentPlayer = player1;
        ticTacToe.setBoard(board);
    }

    @Test
    void testSwitchCurrentPlayer() {
        // Positive test: Verify the player switching logic
        ticTacToe.switchCurrentPlayer();
        assertEquals(player2.getMarker(), ticTacToe.getCurrentPlayerMarker());
        ticTacToe.switchCurrentPlayer();
        assertEquals(player1.getMarker(), ticTacToe.getCurrentPlayerMarker());
    }


    @Test
    void testHasWinner() {
        // Positive test:Verify the winner detection logic
        char[][] cells = {{'X', 'X', 'X'}, {'O', ' ', ' '}, {' ', ' ', ' '}};
        when(board.getCells()).thenReturn(cells);
        assertEquals('X', ticTacToe.hasWinner('X'));
    }

    @Test
    void testHasWinnerWithNoWinner() {
        // Negative test: Verify that no winner returns' '
        char[][] cells = {{'X', 'O', 'X'}, {'O', ' ', ' '}, {' ', ' ', ' '}};
        when(board.getCells()).thenReturn(cells);
        assertEquals(' ', ticTacToe.hasWinner('X'));
    }


}
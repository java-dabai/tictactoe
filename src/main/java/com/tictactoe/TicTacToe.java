package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {


    public Player player1;

    public Player player2;

    public Player currentPlayer;

    public Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public char getCurrentPlayerMarker() {
        return currentPlayer.getMarker();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

  

    public void start() {
        try (Scanner input = new Scanner(System.in);) {
            char flag;

            do {
                game(input);

                System.out.print("Do you want to do again? （y/n）: ");
                flag = input.next().charAt(0);
            } while (flag == 'y' || flag == 'Y');
        }
    }

    /**
     * tictactoe game
     */
    public void game(Scanner input) {
        char[][] cells = this.board.getCells();
        char winner = 'X';   //winner

        this.board.clear();//Clear the board

        while (true) {
            this.board.print();//Output board

            if (hasWinner(player1.getMarker()) != ' ') {
                winner = player1.getMarker();
                break;
            }
            if (hasWinner(player2.getMarker()) != ' ') {
                winner = player2.getMarker();
                break;
            }
            if (this.board.isFull()) break;    //When the board is full, exit the loop

            int row, column;
            do {
                System.out.print("Enter a row (0, 1, or 2) for player " + currentPlayer.getMarker() + ": ");
                row = input.nextInt();
                System.out.print("Enter a column (0, 1, or 2) for player " +
                        currentPlayer.getMarker() + ": ");
                column = input.nextInt();

                if (row < 0 || row > 2)
                    System.out.println("You should enter row from 0, 1, or" +
                            " 2. Enter again!");
                else if (column < 0 || column > 2)
                    System.out.println("You should enter column from 0, " +
                            "1, or 2. Enter again!");
                else break;
            } while (true);

            if (!board.isCellEmpty(row, column)) { //If there are already pieces on the board, output information and end the loop
                System.out.println("Has existed " + cells[row][column] + ". Continue");
                continue;
            } else {
                board.place(row, column, currentPlayer.getMarker());//Spaces as pieces (X/O)
            }

            switchCurrentPlayer();//Change the player
        }

        if (this.board.isFull())    //When the board is full, output a draw
            System.out.println("draw");
        else    //Otherwise, output the winner
            System.out.println(winner + " player won");
    }


    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }


    //Determines whether there is a winner and returns the winner if there is one
    public char hasWinner(char player) {

        char[][] cells = this.board.getCells();

        for (int i = 0; i < cells.length; i++)
            if (cells[i][0] == player && cells[i][1] == player && cells[i][2] == player)
                return player;

        for (int i = 0; i < cells[0].length; i++)
            if (cells[0][i] == player && cells[1][i] == player && cells[2][i] == player)
                return player;

        if (cells[0][0] == player && cells[1][1] == player && cells[2][2] == player ||
                cells[0][2] == player && cells[1][1] == player && cells[2][0] == player)
            return player;

        return ' ';    //If there is no winner, return ' '
    }

}
























package com.tictactoe;

public class Board {

    public char[][] cells;

    public char[][] getCells() {
        return cells;
    }


    public Board() {
        this.cells = new char[3][3];
    }


    public boolean isCellEmpty(int x, int y) {
        return this.cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        this.cells[x][y] = marker;
    }


    public boolean isFull() {
        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells.length; j++)
                if (cells[i][j] == ' ')
                    return false;
        return true;
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = ' ';
            }
        }
    }


    public void print() {
        for (int i = 0; i < cells.length; i++) {
            System.out.println(" —————————————");
            for (int j = 0; j < cells.length; j++)
                System.out.print(" | " + cells[i][j]);
            System.out.println(" |");
        }
        System.out.println(" —————————————");
    }
}

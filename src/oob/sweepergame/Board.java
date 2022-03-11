package oob.sweepergame;

import java.util.Random;

public class Board {

    private final int width;
    private final int length;
    private final int numOfMines;

    private Cell[][] board;


    public Board(int length, int width, int numOfMines) {

        this.width = width;
        this.length = length;
        this.numOfMines = numOfMines;

        board = new Cell[length][width];
        generate();
    }

    private void generate() {
        genMines();
        genNum();

    }

    private void genMines() {

        int currentNumOfMines = 0;
        Random random = new Random();


        while (currentNumOfMines < numOfMines) {

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {

                    double probability = random.nextDouble();

                    if (board[i][j] == null) {
                        board[i][j] = new Cell(i, j, false, board.clone());
                    } else if (board[i][j].isMine()) {

                    } else if (probability > 0.99999 && currentNumOfMines < numOfMines) {
                        board[i][j] = new Cell(i, j, true, board.clone());
                        currentNumOfMines++;
                    }
                }
            }
        }
    }

    private void genNum() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j].isMine()) {

                } else {
                    board[i][j].setValue();
                }
            }
        }
    }

    public void printBoard() {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j].isMine()) {

                }
                System.out.print(" " + board[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    public void printSolvedBoard() {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j].isMine()) {

                }
                System.out.print(" " + board[i][j].getValue());
            }
            System.out.println();
        }
    }

    public Cell[][] getBoard() {
        return board;
    }
}
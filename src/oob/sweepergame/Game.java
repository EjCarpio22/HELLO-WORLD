package oob.sweepergame;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Board board;

    public Game(int length, int width,int numOfMines) {

        board = new Board(length, width, numOfMines);

        option();

        System.out.println("Generating Board");

        start();

    }

    public void start() {
        while (true) {
            userInput();
        }
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("οοοοοοοοοοοοοοοοοοοο");
        System.out.println("ο MINESWEEPER GAME ο");
        System.out.println("οοοοοοοοοοοοοοοοοοοο");
        System.out.println("INPUT Values");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("Key IN Length: ");
        int length = scan.nextInt();

        System.out.print("KEY IN Width: ");
        int width =  scan.nextInt();

        System.out.print("KEY IN # Of Mines: ");
        int numOfMines = scan.nextInt();

        new Game(length,width,numOfMines);
    }


    public void option() {
        System.out.println();
        System.out.println("Options:");
        System.out.println("      \"select\" - select cell");
        System.out.println("      \"flag\"   - flag cell");
        System.out.println("      \"restart\"- start new game");
        System.out.println("      \"quit\"   - quit game");
        System.out.println();
    }

    void userInput() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Option: ");
        String userInput;

        userInput = scan.nextLine();
        userInput = userInput.trim().toLowerCase();

        int row;
        int column;

        switch (userInput)
        {

            case "select":

                System.out.print("Row: ");
                row = scan.nextInt() - 1;

                System.out.print("Column: ");
                column = scan.nextInt() - 1;

                choose(row, column);
                board.printBoard();
                break;

            case "restart":

                System.out.print("Length: ");
                int length = scan.nextInt();

                System.out.print("Width: ");
                int width =  scan.nextInt();

                System.out.print("Number Of Mines: ");
                int numOfMines = scan.nextInt();

                restart(length, width, numOfMines);
                break;

            case "flag":

                System.out.print("Row: ");
                row = scan.nextInt()-1;

                System.out.print("Column: ");
                column =  scan.nextInt()-1;

                flag(row, column);
                board.printBoard();
                break;

            case "quit":

                scan.close();
                System.exit(0);

            case "":
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    void choose(int row, int column) {
        Cell cell = board.getBoard()[row][column];
        if (cell.isMine()) {
            System.out.println("You lose! You chose a mine.");
        } else if (cell.hasValue()) {
            cell.show();
        } else if (!cell.hasValue()) {
            reveal(cell, new ArrayList<>(),0);
        }
    }

    public void reveal(Cell cell, ArrayList<Cell> processed,int i) {

        cell.show();
        System.out.println(i);
    }

    void flag(int row, int column) {

        Cell cell = board.getBoard()[row][column];
        cell.setFlagged(!cell.isFlagged());

    }

    void restart(int length, int width, int numOfMines) {
        System.out.println("Generating new Board");
        board = new Board(length, width, numOfMines);
    }
}


package oob.sweepergame;

import java.util.ArrayList;
import java.util.Arrays;

public class Cell {


    private final int axisX;
    private final int axisY;

      private final boolean isBomb;
    private boolean isFlagged;
    private boolean isSeen;

    private String symbol;
    private String value;


    private final Cell[][] gBoard;
    private final ArrayList<Cell> rCells = new ArrayList<>();

    public Cell(int x, int y, boolean isMine, Cell[][] board) {

        this.isBomb = isMine;
        this.isFlagged = false;
        this.isSeen = false;

        this.gBoard = board;

        this.axisX = x;
        this.axisY = y;
        symbol = "*";

        if (this.isBomb) {
            value = "#";
        }
    }

    public boolean isMine() {
        return isBomb;
    }

    public String getSymbol() {
        return symbol;
    }

    public void show() {
        symbol = value;
        isSeen = true;
    }

    public boolean isShown() {
        return isSeen;
    }

    public boolean hasValue() {

        if (isBomb) return false;

        return Integer.parseInt(value) > 0;
    }

    public ArrayList<Cell> getrCells() {

        if (rCells.isEmpty()) {
            setrCells();
        }

        return rCells;
    }

    private void setrCells() {
        for (int i = axisX - 1; i <= axisX + 1; i++) {
            for (int j = axisY- 1; j <= axisY + 1; j++) {

                if (i == axisX && j == axisY) {

                } else {
                    try {
                        rCells.add(gBoard[i][j]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue() {

        if (isBomb) {
            return;
        }

        if (Arrays.asList(gBoard).contains(null)) {
            return;
        }

        int surroundingMines = 0;

        for (Cell cell : getrCells()) {
            if (cell.isMine()) {
                surroundingMines++;
            }
        }

        value = Integer.toString(surroundingMines);
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;

        if (isSeen) {
            return;
        } else if (isFlagged) {
            symbol = "F";
        } else {
            if (isBomb) {
                symbol = "#";
            } else if (isSeen) {
                symbol = value;
            } else {
                symbol = "*";
            }
        }
    }

}
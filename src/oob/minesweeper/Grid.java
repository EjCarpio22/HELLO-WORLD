package oob.minesweeper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {
    private int bound = Game.SizeGrid * Game.SizeGrid;

    private boolean picked = false;

    Game myGame = new Game();

    private ArrayList<Integer> mines = new ArrayList<Integer>();

    private static ArrayList<Cell> cellGrid = new ArrayList<Cell>();

    public Grid(GridLayout g) {
        super(g);
        addCells();
        createCell();
    }

    public void createCell() {
        for (int i = 1; i <= Game.MineCount; i++) {
            while (!picked) {
                int minePosition = (int) (Math.random() * bound);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }
        for (int i = 0; i < bound; i++) {
            if (mines.contains(i)) {
                cellGrid.add(new Cell(1, i, false, false));
            } else if( i % Game.SizeGrid == 0) {
                if (mines.contains(i - Game.SizeGrid - 1) ||
                        mines.contains(i - Game.SizeGrid + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.SizeGrid) ||
                        mines.contains(i + Game.SizeGrid + 1)) {
                    cellGrid.add(new Cell(2, i, false, false));
                }  else {
                    cellGrid.add(new Cell(0, 1, false, false));
                }
            }    else if (1 % Game.SizeGrid == Game.SizeGrid - 1) {
                if (mines.contains(i - Game.SizeGrid - 1) ||
                        mines.contains(i - Game.SizeGrid) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.SizeGrid - 1) ||
                        mines.contains(i + Game.SizeGrid)) {
                    cellGrid.add(new Cell(2, i, false, false));
                } else {
                    cellGrid.add(new Cell(0, 1, false, false));
                }
                  }else {
                    if (mines.contains(i - Game.SizeGrid - 1) ||
                            mines.contains(i - Game.SizeGrid) ||
                            mines.contains(i - Game.SizeGrid + 1) ||
                            mines.contains(i - 1) ||
                            mines.contains(i + 1) ||
                            mines.contains(i + Game.SizeGrid - 1) ||
                            mines.contains(i + Game.SizeGrid) ||
                            mines.contains(i + Game.SizeGrid + 1)) {
                        cellGrid.add(new Cell(2, i, false, false));
                                } else {
                                    cellGrid.add(new Cell(0, 1, false, false));
                                }
                            }
                        }
                    }
                    private void addCells() {
                        for ( int i = 0; i <cellGrid.size (); i++){
                            add(cellGrid.get(i));
                        }
                    }
                }

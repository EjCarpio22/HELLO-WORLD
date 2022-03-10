package oob.minesweeper;

public class Game {

    public static final int Width = 550, Height = 550;
    public static final int SizeGrid = 10;
    public static final int MineCount = 10;

    public Game (){
        new Window(Width,Height,SizeGrid,"Minesweeper Game");

    }
    public static void main(String[] args) {
        new Game();
    }
}
package oob.minesweeper;

import javax.swing.*;
import java.awt.*;

public class Window {
    private static JFrame frame;
    public static String title;

    public Window(int Width, int Height, int SizeGrid, String title) {
        Window.title = title;
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(Width, Height));
        frame.setMinimumSize(new Dimension(Width, Height));
        frame.setMaximumSize(new Dimension(Width, Height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel= new Grid(new GridLayout(SizeGrid, SizeGrid));

        frame.setVisible(true);
    }
}

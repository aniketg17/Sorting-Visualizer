package GUI;


import javax.swing.*;
import java.awt.*;


public abstract class BaseScreen extends JPanel {
    protected FrameHandler app;

    public BaseScreen(FrameHandler app) {
        this.app = app;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SortVisualizer.WIN_WIDTH, SortVisualizer.WIN_HEIGHT);
    }

    public abstract void onOpen();
}
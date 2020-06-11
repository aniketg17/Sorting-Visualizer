package GUI;


import javax.swing.*;
import java.awt.*;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

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
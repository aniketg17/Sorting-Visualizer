package GUI;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

public class FrameHandler {
    private final JFrame window;


    private final ArrayList<BaseScreen> screens;

    public FrameHandler() {
        screens = new ArrayList<>();
        window = new JFrame ("Sort Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
    }

    public void pushScreen(BaseScreen screen) {
        if (!screens.isEmpty()) {
            screens.get(screens.size() - 1).setVisible(false);
        }
        screens.add(screen);
        window.add(screen);
        window.pack();
        screen.onOpen();
    }

    public void popScreen() {
        if (!screens.isEmpty()) {
            BaseScreen prev = screens.get(screens.size() - 1);
            prev.setVisible(false);
            screens.remove(prev);
            window.remove(prev);
            if (!screens.isEmpty()) {
                screens.get(screens.size() - 1).onOpen();
                screens.get(screens.size() - 1).setVisible(true);
            }
            else
                window.dispose();
        }
    }

    public void start() {
        pushScreen(new Menu(this));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrameHandler().start());
    }
}
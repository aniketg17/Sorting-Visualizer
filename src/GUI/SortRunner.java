package GUI;

import SortingAlgorithms.Sorter;

import javax.swing.*;
import java.util.ArrayList;



public final class SortRunner extends BaseScreen {
    private final SortVisualizer visualize;
    private final ArrayList<Sorter> sortQueue;

    public SortRunner(ArrayList<Sorter> algorithms, FrameHandler app) {
        super(app);
        visualize = new SortVisualizer();
        add(visualize);

        sortQueue = algorithms;
    }

    private void shuffleAndWait() {
        visualize.shuffle();
        visualize.resetColours();
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void onOpen() {
        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                for (Sorter algorithm : sortQueue) {
                    shuffleAndWait();

                    visualize.setName(algorithm.toString());
                    algorithm.sort(visualize);

                    visualize.resetColours();
                    visualize.highlightArray();
                    visualize.resetColours();
                }
                return null;
            }

            @Override
            public void done() {
                app.popScreen();
            }
        };

        swingWorker.execute();
    }
}
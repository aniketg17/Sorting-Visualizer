import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ArrayVisualization extends JPanel {
    private int[] array;
    private static final int BAR_WIDTH = 5;
    private final static int WIN_WIDTH = 1280;
    private final static int WIN_HEIGHT = 720;
    private static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;

    public int getArraySize() {
        return this.array.length;
    }

    public int getArrayValue(int x) {
        return this.array[x];
    }

    public ArrayVisualization() {
        array = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
        }
        shuffleArray();
//        InsertionSort sort = new InsertionSort();
//        sort.sort(array);
    }

    public void shuffleArray() {
        Random rand = new Random();
        for (int i = 0; i < NUM_BARS ; i++) {
            int randomNumber = rand.nextInt(NUM_BARS - 1);
            delayedSwap(i, randomNumber, 500);
        }
    }

    public void delayedSwap(int idx1, int idx2, int timeInMs) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;

        repaint();
        sleepFor( 500);
    }

    public static void sleepFor(long time) {
        long elapsed;
        final long startTime = System.nanoTime();
        do {
            elapsed = System.nanoTime()-startTime;
        } while (elapsed < time);
    }

    public void arrayScreen() {
        JFrame frame = new JFrame("Sorting Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        ArrayVisualization panel = new ArrayVisualization();
        frame.add(panel);

        frame.setSize(WIN_WIDTH, WIN_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);


        graphics.setColor(Color.BLACK);
        for (int i = 0; i < NUM_BARS; i++) {
            int height = array[i] * 2;
            int xBegin = i + (BAR_WIDTH - 1) * i;
            int yBegin = WIN_HEIGHT - height;

            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
        }
    }
}

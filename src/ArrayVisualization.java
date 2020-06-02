import javax.swing.*;
import java.awt.*;

public class ArrayVisualization extends JPanel {
    private int[] array;
    private static final int BAR_WIDTH = 5;
    private final static int WIN_WIDTH = 1280;
    private final static int WIN_HEIGHT = 720;
    private static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;


    public ArrayVisualization() {
        array = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
        }
    }

    public void arrayScreen() {
        JFrame frame = new JFrame("Oval Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        ArrayVisualization panel = new ArrayVisualization();
        frame.add(panel);

        frame.setSize(WIN_WIDTH, WIN_HEIGHT);
        frame.setVisible(true);
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

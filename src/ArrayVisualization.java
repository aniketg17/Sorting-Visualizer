import javax.swing.*;
import java.awt.*;

public class ArrayVisualization extends JPanel {
    private int[] array;
    private static final int BAR_WIDTH = 4;
    private static final int NUM_BARS = MenuGUI.getWinWidth() / BAR_WIDTH;
    Color color;


    public ArrayVisualization(Color color) {
        this.color = color;
        array = new int[500];
        for (int i = 0; i < 500; i++) {
            array[i] = i;
        }
    }

    public void arrayScreen() {
        JFrame frame = new JFrame("Oval Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(2, 2));

        Color colors[] = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };
        for (int i = 0; i < 4; i++) {
            ArrayVisualization panel = new ArrayVisualization(colors[i]);
            frame.add(panel);
        }

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);

        for (int i = 0; i < array.length; i++) {
            graphics.drawLine(i,MenuGUI.getWinWidth(),i,array[i]);
        }

//        graphics.setColor(Color.BLUE);
//
//        for (int i = 0; i < NUM_BARS; i++) {
//            int height = array[i] * 2;
//            int xBegin = i + (BAR_WIDTH - 1) * i;
//            int yBegin = MenuGUI.getWinHeight() - height;
//            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
//        }
//        graphics.setColor(Color.BLUE);
//        graphics.drawRect(0,0,MenuGUI.getWinWidth(), MenuGUI.getWinHeight());
//        int width = getWidth();
//        int height = getHeight();
//        g.setColor(Color.BLUE);
//        g.drawOval(0, 0, width, height);
    }
}

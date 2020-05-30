import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizerGUI {
    JCheckBox[] sortingAlgorithmChoices = new JCheckBox[6];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainMenu();
            }
        });
    }

    public static void mainMenu() {
        JFrame mainScreen = new JFrame("Sorting Visualizer");
        mainScreen.setLayout(new BorderLayout());
        mainScreen.setSize(1200, 900);
        mainScreen.setLocationRelativeTo(null);
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        JLabel mainTitle = new JLabel("<html><div style='text-align: center;'><b> Welcome to the Sorting " +
                "Algorithm Visualizer </div></b></html>");
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setFont(new Font("Courier", Font.BOLD, 30));
        mainPanel.add(mainTitle);

        JPanel checkboxes = new JPanel(new GridLayout(2,3));



        mainScreen.setContentPane(mainPanel);
    }
}

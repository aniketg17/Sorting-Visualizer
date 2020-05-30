import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizerGUI {
    static JCheckBox[] sortingAlgorithmChoices = new JCheckBox[6];

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

        sortingAlgorithmChoices[0] = new JCheckBox(new BubbleSort().toString());
        sortingAlgorithmChoices[1] = new JCheckBox(new HeapSort().toString());
        sortingAlgorithmChoices[2] = new JCheckBox(new InsertionSort().toString());
        sortingAlgorithmChoices[3] = new JCheckBox(new MergeSort().toString());
        sortingAlgorithmChoices[4] = new JCheckBox(new RadixSort().toString());
        sortingAlgorithmChoices[5] = new JCheckBox(new RandomizedQuicksort().toString());


        JPanel checkboxPanel = new JPanel(new GridLayout(0,2, 5 , 5));
        checkboxPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        for (JCheckBox checkBox : sortingAlgorithmChoices) {
            checkBox.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            checkboxPanel.add(checkBox);
        }
        mainPanel.add(checkboxPanel);
        mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);


        JPanel buttonHolder = new JPanel();
        JButton submit = new JButton("Sort!");
        buttonHolder.add(submit);
        mainPanel.add(buttonHolder);

        mainScreen.setContentPane(mainPanel);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuGUI {
    private static JCheckBox[] sortingAlgorithmChoices = new JCheckBox[6];
    private final static int WIN_WIDTH = 1200;
    private final static int WIN_HEIGHT = 720;

    public static int getWinWidth() {
        return WIN_WIDTH;
    }

    public static int getWinHeight() {
        return WIN_HEIGHT;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuGUI::mainMenu);
    }

    public static void mainMenu() {


        JFrame mainScreen = new JFrame("Sorting Visualizer");
        mainScreen.setLayout(new BorderLayout());
        mainScreen.setSize(1200, 720);
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

        Listener checkboxListener = new Listener();
        for (JCheckBox checkBox : sortingAlgorithmChoices) {
            checkBox.addItemListener(checkboxListener);
            checkBox.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            checkboxPanel.add(checkBox);
        }
        mainPanel.add(checkboxPanel);
        mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);


        JPanel buttonHolder = new JPanel();
        JButton submit = new JButton("Sort!");
        submit.addActionListener(actionEvent -> {
            ArrayVisualization arrayVisualization = null;
            arrayVisualization = new ArrayVisualization();
            arrayVisualization.arrayScreen();
        });

        buttonHolder.add(submit);
        mainPanel.add(buttonHolder);

        mainScreen.setContentPane(mainPanel);

    }

    static class Listener implements ItemListener {

        private int selectionCounter = 0;

        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox source = (JCheckBox) e.getSource();

            int MAX_SELECTIONS = 2;
            if (source.isSelected()) {
                selectionCounter++;
                // check for max selections:
                if (selectionCounter == MAX_SELECTIONS)
                    for (JCheckBox box: sortingAlgorithmChoices)
                        if (!box.isSelected())
                            box.setEnabled(false);
            }
            else {
                selectionCounter--;
                // check for less than max selections:
                if (selectionCounter < MAX_SELECTIONS)
                    for (JCheckBox box: sortingAlgorithmChoices)
                        box.setEnabled(true);
            }
        }
    }
}

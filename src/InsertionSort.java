import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertionSort extends Sorter {
    //    @Override
//    public void sort(ArrayVisualization array) {
//        for (int i = 0; i < array.getArraySize(); i++) {
//            int j = i - 1;
//            int key = array.getArrayValue(i);
//            while (j >= 0 && array.getArrayValue(j) > key) {
//                array.delayedSwap(j, j+1);
//                System.out.println("called ");
//                --j;
//            }
//        }
//    }
    @Override
    public void sort(ArrayVisualization array) { // ArrayVisualization object to change array values
        int timerDelay = 1;  // or however many msecs desired
        new Timer(timerDelay, new TimerListener(array)).start();
    }


    static class TimerListener implements ActionListener {
        private ArrayVisualization array;
        private int arrayIndex = 0;
        private int innerIndex = 0;
        int key = 0;
        private boolean insideInnerLoop = false;

        public TimerListener(ArrayVisualization array) {
            this.array = array;
        }

        public void actionPerformed(ActionEvent e) {

            if (!insideInnerLoop) {
                insideInnerLoop = true;
                innerIndex = arrayIndex - 1;
                key = array.getArrayValue(arrayIndex);
            } else {
                if (innerIndex < 0 || array.getArrayValue(innerIndex) > key) {
                    insideInnerLoop = false;
                    arrayIndex++;
                   // break;
                } else {
                    array.delayedSwap(innerIndex, arrayIndex);
                    // swap code here
                    innerIndex--;
                }
            }
            // ......


            if (arrayIndex >= array.getArraySize()) {
                ((Timer) e.getSource()).stop();
            }
        }
    }

//    static class TimerListener implements ActionListener {
//        private ArrayVisualization array;
//        private int arrayIndex = 1;
//        private int interimTemp = arrayIndex;
//
//        public TimerListener(ArrayVisualization array) {
//            this.array = array;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println("called ");
//
//            //array.delayedSwap(10, 20);
//
//            // ...... if blocks and code in here
//            int j = interimTemp - 1;
//            int key = array.getArrayValue(arrayIndex);
//            if (j >= 0 && array.getArrayValue(j) > key) {
//                array.delayedSwap(j, j+1);
//                --interimTemp;
//            } else {
//                arrayIndex++;
//            }
//            if (arrayIndex >= array.getArraySize()) {
//                ((Timer) actionEvent.getSource()).stop();
//            }
//        }
//    }


    @Override
    public String toString() {
        return "Insertion Sort";
    }
}
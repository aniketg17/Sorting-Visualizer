package SortingAlgorithms;
import GUI.SortVisualizer;

public class BubbleSort extends Sorter {
    @Override
    public void sort(SortVisualizer array) {
        for (int i = 0; i < array.getArraySize(); i++) {
            for (int j = 0; j < array.getArraySize() - i - 1; j++) {
                if (array.getArrayValue(j) > array.getArrayValue(j+1)) {
                    array.swap(j+1, j, 5);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }

    @Override
    public long getDelay() {
        return 2;
    }
}

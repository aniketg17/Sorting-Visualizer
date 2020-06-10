package SortingAlgorithms;

import GUI.SortVisualizer;

public class InsertionSort extends Sorter {
        @Override
    public void sort(SortVisualizer array) {
        for (int i = 0; i < array.getArraySize(); i++) {
            int j = i - 1;
            int key = array.getArrayValue(i);
            while (j >= 0 && array.getArrayValue(j) > key) {
                array.swap(j, j+1, 2);
                System.out.println("called ");
                --j;
            }
        }
    }



    @Override
    public String toString() {
        return "Insertion Sort";
    }

    @Override
    public long getDelay() {
        return 2;
    }
}
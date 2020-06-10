package SortingAlgorithms;

import GUI.ArrayVisualization;

public class InsertionSort extends Sorter {
        @Override
    public void sort(ArrayVisualization array) throws InterruptedException {
        for (int i = 0; i < array.getArraySize(); i++) {
            int j = i - 1;
            int key = array.getArrayValue(i);
            while (j >= 0 && array.getArrayValue(j) > key) {
                array.delayedSwap(j, j+1);
                System.out.println("called ");
                --j;
            }
        }
    }



    @Override
    public String toString() {
        return "Insertion Sort";
    }
}
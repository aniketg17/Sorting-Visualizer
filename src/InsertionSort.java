public class InsertionSort extends Sorter {
    @Override
    public void sort(ArrayVisualization array) {
        for (int i = 0; i < array.getArraySize(); i++) {
            int j = i - 1;
            int key = array.getArrayValue(i);
            while (j >= 0 && array.getArrayValue(j) > key) {
                array.delayedSwap(j, j+1, 2);
                --j;
            }
        }
    }

    @Override
    public String toString() {
        return "Insertion Sort";
    }
}

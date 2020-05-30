public class InsertionSort extends Sorter {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i - 1;
            int key = array[i];
            while (j >= 0 && array[j] > key) {
                array[j] = array[j] ^ array[j+1];
                array[j+1] = array[j] ^ array[j+1];
                array[j] = array[j] ^ array[j+1];
                --j;
            }
        }
    }
}

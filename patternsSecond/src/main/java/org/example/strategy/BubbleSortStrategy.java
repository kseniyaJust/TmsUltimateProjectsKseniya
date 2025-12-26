package org.example.strategy;

public class BubbleSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        int i, j, temp;
        int n = array.length;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

    }
    }
}

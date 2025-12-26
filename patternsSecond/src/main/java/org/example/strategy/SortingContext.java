package org.example.strategy;

public class SortingContext {
    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array){
        sortingStrategy.sort(array);

        System.out.print("Result array: ");
        for(int el: array){
            System.out.print(el + " ");
        }
    }
}

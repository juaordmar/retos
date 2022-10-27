package sort_algorithms;

import java.util.Random;

public class mergeSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        utiles.printArray(numbers);

        mergeSort(numbers);
        System.out.println("After:");
        utiles.printArray(numbers);
    }

}
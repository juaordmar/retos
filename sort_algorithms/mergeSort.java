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
        System.out.println("\nAfter:");
        utiles.printArray(numbers);
    }

    private static void mergeSort(int[] array) {
        int inputLength = array.length;
        if (inputLength < 2) { // Caso base
            return;
        }

        int mid = inputLength / 2;
        int[] lh = new int[mid]; // mitad izquierda
        int[] rh = new int[inputLength - mid]; // mitad derecha
        for (int i = 0; i < mid; i++) {
            lh[i] = array[i];
        }
        for (int i = mid; i < inputLength; i++) {
            rh[i - mid] = array[i];
        }

        mergeSort(lh);
        mergeSort(rh);

        merge(array, lh, rh);

    }

    private static void merge(int[] array, int[] lh, int[] rh) {

        int ls = lh.length;
        int rs = rh.length;

        // Comparamos los valores de los arrays y los ordenamos
        int i = 0, j = 0, k = 0; // i para lh, j para rh, k para mergeArray
        while (i < ls && j < rs) {
            if (lh[i] <= rh[j]) {
                array[k] = lh[i];
                i++;
            } else {
                array[k] = rh[j];
                j++;
            }
            k++;
        } // Añadimos los valores que hayan quedado después de haber llegado a ls o rs
        while (i < ls) {
            array[k] = lh[i];
            i++;
            k++;
        }
        while (j < rs) {
            array[k] = rh[j];
            j++;
            k++;
        }

    }

}
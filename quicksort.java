import java.util.Random;

public class quicksort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quicksort(numbers);
        System.out.println("\nAfter:");
        printArray(numbers);

    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }
        // vamos a usar punteros para movernos entre los números una vez quitado el
        // pivot, tener un pivot random es mejor para la eficiencia del algoritmo
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        // lp(left pointer) va hacia la derecha y el rp(right pointer), hacia la
        // izquierda
        // cuando lp encuentra un numero mayor que el pivot y hp uno menor hacemos un
        // swap
        // de los dos numeros señalados
        int lp = lowIndex;
        int rp = highIndex;

        while (lp < rp) {
            while (array[lp] <= pivot && lp < rp) {
                lp++;
            }
            while (array[rp] >= pivot && lp < rp) {
                rp--;
            }
            swap(array, lp, rp);
        }

        swap(array, lp, highIndex);
        // en este punto todos los valores mayores que el pivot deberian estar a su
        // derecha
        // y los menores a su izquierda, lo restante es llamar al algoritmo para estas
        // dos mitades

        quicksort(array, lowIndex, lp - 1); // mitad izquierda
        quicksort(array, lp + 1, highIndex); // mitad derecha

    }

    private static void swap(int[] array, int i1, int i2) {
        // metodo de la burbuja
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

}
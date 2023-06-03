import java.util.Random;

public class homework2 {
    public static void main(String[] args) {
        int[] array = new int[10000000];
        fillArray(array);

        long startTime = System.currentTimeMillis();
        pyramidSort(array);
        long endTime = System.currentTimeMillis() - startTime;

        System.out.println("Time: " + endTime);
        printArray(array);
    }

    // Заполнение массива случайными числами
    public static void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000000);
        }
    }

    // Функция для печати массива
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    // Пирамидальная сортировкa
    public static void pyramidSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0 ; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild  = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, heapSize, largest);
        }
    }

}
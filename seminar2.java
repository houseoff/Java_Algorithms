import java.util.Random;

public class seminar2 {
    public static void main(String[] args) {
        int[] array = new int[100000];
        fillArray(array);

        long startTime = System.currentTimeMillis();
        quickSort(array, 0,array.length - 1);

        System.out.println(System.currentTimeMillis() - startTime);
    }

    // Заполнение массива случайными числами
    public static void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
    }

    // Функция для печати массива
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    // Написать две сортировки сложностью O(n^2)
    // Сортировка выбором
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) min = j;
            }

            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    // Сортировка вставками
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // Быстрая сортировка
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int leftPos = start;
        int rightPos = end;
        int pivot = array[start + (end - start) / 2];
        do {
            while (array[leftPos ] < pivot) leftPos++;
            while (array[rightPos] > pivot) rightPos--;

            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos <= rightPos);

        if (leftPos < end)    quickSort(array, leftPos, end);
        if (start < rightPos) quickSort(array, start, rightPos);

    }

}

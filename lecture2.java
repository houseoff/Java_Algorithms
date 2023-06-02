public class lecture2 {
    public static void main(String[] args) {
        int[] array = new int[]{4,2,5,8,1,9,2,3,6,5};
        directSort(array);
        System.out.println(binarySearch(array, 9));
    }

    // Пузырьковая сортировка. Попарное сравнение элементов. Наименьший элемент "всплывает", т.е. ставится первее
    // Сложность алгоритма = O(n^2)
    private static void bubbleSort(int[] array) {
        boolean finish = true;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i + 1] = temp; 
                    finish = false;
                }
            }
        }
        while(!finish);
    }

    // Сортировка выбором. Минимальный элемент в начало массива
    // Сложность алгоритма = O(n^2)
    // Cортировка неоптимальна, однако, такая сортировка быстрее пузырьковой, так как за каждый проход внешнего цикла будет совершаться одна операция обмена
    private static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }

            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp; 
            }
        }
    }

    // Сортировка вставками. Если элемент на i позиции больше элемента на j позиции, то элементы меняются позициями
    // Сложность алгоритма = O(n^2)
    // Сортировка медленнее сортировки выбором, но быстрее пузырьковой сортировки
    private static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                } 
            }
        }
    }

    // Простой поиск в массиве
    // Сложность = O(n)
    // Неплохо, но надо лучше))
    private static int simpleSearch(int[] array, int searchable) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchable) {
                return i;
            }
        }
        return -1;
    }

    // Бинарный поиск. Работает с отсортированным массивом!
    // Такой алгоритм типа "Разделяй и властвуй" реализуется с помощью рекурсии
    // Сложность алгоритма = n * log(n)
    private static int binarySearch(int[] array, int searchable, int min, int max) {
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        
        if (array[midpoint] < searchable) {
            return binarySearch(array, searchable, midpoint + 1, max);
        } else {
            if (array[midpoint] > searchable) {
                return binarySearch(array, searchable, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }

    // Перегрузка метода binarySearch при вызове метода с двумя параметрами: отсортированный массив и искомое значение
    // Минимальное значение отрезка для поиска - индекс первого элемента массива, максимальное - индекс последнего элемента массива
    private static int binarySearch(int[] array, int searchable) {
        return binarySearch(array, searchable, 0, array.length - 1);
    }

    // Продвинутые сортировки, такие как, быстрая сортировка и пирамидальная сортировка разобраны в методичке
}

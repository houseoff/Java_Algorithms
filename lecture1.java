import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class lecture1 {
    
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Count: " + counter.get());
    }

    // Поиск делителей числа. Сложность алгоритма = O(n). Кол-во операций всегда соответствует количеству входных данных
    public static List<Integer> findAvailableDivider(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }

        return result;
    }

    // Поиск простых чисел на отрезке от 0 до n. С ростом входных данных на 1 ед., кол-во действий растет нелинейно
    // В данном случае, зависимость квадратичая = O(n^2) (два цикла for)
    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            
            if (simple) {
                result.add(i);
            }
        }

        System.out.println("Counter: " + counter);
        return result;
    }

    // Нахождение числа Фибоначчи рекурсивно. Зависимость скорости от данных - экспоненциальная = O(2^n)
    private static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 1) {
            return 0;
        }

        if (position == 2) {
            return 1;
        }

        return fib(position - 1, counter) + fib(position - 2, counter);
    }
}

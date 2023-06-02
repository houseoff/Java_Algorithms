import java.util.ArrayList;
import java.util.List;

public class seminar1 {
    
    public static void main(String[] args) {
        System.out.println(fib2(10));
    }

    // Сумма от 1 до n
    private static int sum(int number) {
        int sum = ((1 + number) * number) / 2;
        return sum;
    }

    // Поиск простых чисел от 1 до n
    private static List<Integer> simpleNumbers(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            boolean simple = true;
            for (int j = 2; j <= number; j++) {
                if (i != j && i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) result.add(i);
        }
        return result;
    }

    // Поиск всех доступных комбинаций кубиков k с кол-вом граней d
    private static void findCombinations(int k, int d, List<Integer> combinations) {
        if (combinations.size() == k) return;
        for (int i = 1; i <= d; i++) {
            combinations.add(i);
            findCombinations(k, d, combinations);
            if (combinations.size() == k) System.out.println(combinations);
            combinations.remove(combinations.size() - 1);
        }
    }

    // Поиск n числа последовательности Фибоначчи с помощью рекурсии. Считаем, что первое и второе значение равны единице
    private static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // Поиск n числа последовательности Фибоначчи линейно. Считаем, что первое и второе значение равны единице
    private static long fib2(int n) {
        if (n <= 2) return 1;
        long i1 = 1, i2 = 1;
        while (n-- > 2) {
            long temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
}

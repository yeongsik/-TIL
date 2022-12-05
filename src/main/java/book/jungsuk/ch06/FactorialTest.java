package book.jungsuk.ch06;

public class FactorialTest {
    public static void main(String[] args) {
        int result = factorial(13);
        System.out.println(result);
    }

    private static int factorial(int n) {
        int result = 0;
        if (n <= 0 || n > 12) {
            return -1;
        }
        if (n == 1) {
            result = 1;
        } else {
            result = n * factorial(n - 1);
        }
        return result;
    }
}

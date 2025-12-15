//Print squres using consumers

import java.util.Arrays;
import java.util.List;

public class Consumer {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        java.util.function.Consumer<Integer> printSquare = n -> System.out.println(n * n);

        nums.forEach(printSquare);
    }
}

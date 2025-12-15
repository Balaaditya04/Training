import javax.swing.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.BiFunction;


public class Main {

    public static void main(String[] args) { 

        // Function example: increment
        Function<Integer, Integer> increment = a -> a + 1;
        System.out.println(increment.apply(5));


        // Stream API: Even / Odd labels
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> labels = nums.stream()
                .map(n -> n % 2 == 0 ? "Even" : "Odd")
                .toList();
        System.out.println(labels);


        // Stream API: Celsius to Fahrenheit
        List<Double> celsius = Arrays.asList(36.5, 100.2, 23.4, 25.6);
        Function<Double, Double> toFahrenheit = d -> d * 1.8 + 32;

        celsius.stream()
                .map(toFahrenheit)
                .forEach(System.out::println);


        // Stream API: Student sorting using lambda
        Student[] sts = {
                new Student(90, "Vishal"),
                new Student(85, "Sakshi"),
                new Student(95, "Sumit")
        };

        Arrays.stream(sts)
                .sorted((s1, s2) -> Integer.compare(s2.marks, s1.marks))
                .forEach(s -> System.out.println(s.name + " " + s.marks));


        // BiFunction example
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 20));
    }
}



import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StartA {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Aman", "Ravi", "Anita", "Suman", "Ajay");

        Predicate<String> startsWithA = name -> name.startsWith("A");

        names.forEach(name -> {
            if (startsWithA.test(name)) {
                System.out.println(name);
            }
        });
    }
}


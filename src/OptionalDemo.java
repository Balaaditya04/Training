import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        String name = null; // simulate DB / API value

        Optional<String> nameOpt = Optional.ofNullable(name);

        nameOpt.ifPresent(s -> System.out.println(s));

        // safer alternatives
        System.out.println(nameOpt.orElse("Default Name"));
        // nameOpt.orElseThrow(() -> new RuntimeException("Name not found"));
    }
}

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class PathDemo {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("test.txt");

        if (Files.exists(path)) {
            System.out.println("File exists");
            System.out.println("Size: " + Files.size(path) + " bytes");
            System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
            System.out.println("Is Directory: " + Files.isDirectory(path));
        } else {
            System.out.println("File does not exist");
        }
    }
}

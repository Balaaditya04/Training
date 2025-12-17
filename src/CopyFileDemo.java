import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;

public class CopyFileDemo {

    public static void main(String[] args) throws IOException {

        Path source = Path.of("source.txt");
        Path dest   = Path.of("dest.txt");

        long totalBytes = Files.size(source);
        long copied = 0;
        int bufferSize = 1024;

        try (InputStream in = Files.newInputStream(source);
             OutputStream out = Files.newOutputStream(dest,
                     StandardOpenOption.CREATE,
                     StandardOpenOption.TRUNCATE_EXISTING)) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                copied += bytesRead;

                int progress = (int) ((copied * 100) / totalBytes);
                System.out.println("Progress: " + progress + "%");
            }
        }

        System.out.println("Copy completed");
    }
}

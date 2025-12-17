import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.function.Consumer;

import static java.nio.file.Files.newDirectoryStream;

public class FileDemo5 {
//    public static void formatDir(Path dir) throws IOException {
//        DirectoryStream<Path> filesInsideOurDir =  Files.newDirectoryStream(dir);
//        for(Path p : filesInsideOurDir){
//            // check its size and last modified date
//            if(!Files.isDirectory(p) && Files.size(p)>1024 && p.getFileName().toString().charAt(0)!='.' &&
//                    Duration.between(Files.getLastModifiedTime(p).toInstant(), Instant.now()).toDays() <= 7)
//            System.out.println(p.getFileName());
//            if(Files.isDirectory(p)){
//                formatDir(p);
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        Path p = Path.of("");
        Consumer<Path> formatDir = new Consumer<Path>() {
            @Override
            public void accept(Path path) {
                DirectoryStream<Path> filesInsideOurDir = null;
                try {
                    filesInsideOurDir = newDirectoryStream(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for(Path p : filesInsideOurDir){
                    // check its size and last modified date
                    try {
                        if(!Files.isDirectory(p) && Files.size(p)>1024 && p.getFileName().toString().charAt(0)!='.' &&
                                Duration.between(Files.getLastModifiedTime(p).toInstant(), Instant.now()).toDays() <= 7)
                            System.out.println(p.getFileName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if(Files.isDirectory(p)){
                        accept(p);
                    }
                }
            }
        };
        formatDir.accept(p);
    }
}
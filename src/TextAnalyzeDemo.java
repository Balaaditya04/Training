import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class TextAnalyzeDemo {
    public static void main(String[] args) throws IOException {
        Path p = Path.of("data.txt");
        if(!Files.exists(p)){
            System.out.println("File doesn't exist");
            return;
        }
        BufferedReader br = Files.newBufferedReader(p);
//        Stream<String> lines = br.lines();
//        System.out.println("Total Number of lines " + lines.toList().size());
//        Function<String, Integer> f = s -> s.split(" ").length;
//        lines.forEach(System.out :: println)
        String s = "";
        String maxFWord = "";
        int words = 0, lines = 0, mf = 0;
        Map<String, Integer> mp = new HashMap<>();
        while(br.ready()){
            char ch = (char)br.read();
            if(ch == ' ') {
                mp.put(s, mp.getOrDefault(s, 0)+1);
                if(mp.get(s)>mf){
                    mf = mp.get(s);
                    maxFWord = s;
                }
                words++;
                s = "";
            }
            else if(ch == '\n'){
                mp.put(s, mp.getOrDefault(s, 0)+1);
                if(mp.get(s)>mf){
                    mf = mp.get(s);
                    maxFWord = s;
                }
                lines++;
                s = "";
            }
            else s+=ch;
        }
        System.out.println("Number of Words in the file " + words);
        System.out.println("Number of lines in the file " + lines);
        System.out.println("Most Frequent Word is " + maxFWord);
    }
}
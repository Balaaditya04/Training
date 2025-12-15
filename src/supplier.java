import java.util.*;
import java.util.function.Supplier;

public class supplier {

    public static void main(String[] args) {
        Supplier<Map<String, Integer>> mapSupplier = () -> {
            Map<String, Integer> mp = new HashMap<>();
            mp.put("A", 1);
            mp.put("B", 2);
            return mp;
        };

        Map<String, Integer> map = mapSupplier.get();
        System.out.println(map);
//        List<Integer> l1 = new ArrayList<>();
//
//        Supplier<String> stringSupplier = () -> {
//            if (l1.isEmpty())
//                return "Empty List";
//            return "List has elements";
//        };


    }
}

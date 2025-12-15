import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TotalAmountFinder implements BiFunction<Integer, Integer, Integer>{
    @Override
    public Integer apply(Integer a, Integer b){
        return a*b;
    }
}

public class Bifunction {
    public static void main(String[] args) {
        // 1.Add two integers (from two lists zipped by index).

//        List<Integer> l1 = Arrays.asList(1,2,3,4,5);
//        List<Integer> l2 = Arrays.asList(10,20,30,40,50);
//
//        BiFunction<Integer, Integer, Integer> addTwoNum =
//                (a,b) -> a+b;
//
//        List<Integer> result = IntStream.range(0, l1.size()).
//                mapToObj(i->addTwoNum.apply(l1.get(i), l2.get(i)))
//                .collect(Collectors.toList());
//        System.out.println(result);



        // 2. Multiply price and quantity to get total.
//        List<Integer> price = Arrays.asList(100, 150, 120, 75, 85, 90);
//        List<Integer> quantity = Arrays.asList(1000, 1200, 2000, 1750, 1185, 1990);
//        TotalAmountFinder totalAmountFinder = new TotalAmountFinder();
//
//        List<Integer> result = IntStream.range(0, price.size()).
//                mapToObj(i->totalAmountFinder.apply(price.get(i), quantity.get(i)))
//                .collect(Collectors.toList());
//        System.out.println(result);

        // 3. Take two ints and return gcd.

//        List<Integer> l1 = Arrays.asList(15, 343, 12, 20);
//        List<Integer> l2 = Arrays.asList(25, 7, 28, 32);
//
//        BiFunction<Integer, Integer, Integer> findGCD = new BiFunction<>(){
//            @Override
//            public Integer apply(Integer a, Integer b){
//                if(b == 0) return a;
//                return apply(b, a%b);
//            }
//        };
//
//        List<Integer> result = IntStream.range(0, l1.size()).
//                mapToObj(i -> findGCD.apply(l1.get(i), l2.get(i))).
//                collect(Collectors.toList());
//        System.out.println(result);

        // lcm without using higher order bifunction

//        List<Integer> l1 = Arrays.asList(15, 343, 12, 20);
//        List<Integer> l2 = Arrays.asList(25, 7, 28, 32);
//
//        BiFunction<Integer, Integer, Integer> findLCM = new BiFunction<>(){
//            @Override
//            public Integer apply(Integer a, Integer b){
//                Integer tempa = a, tempb = b;
//                if (a == 0)
//                    return b;
//                else if (b == 0)
//                    return a;
//                while (a != b) {
//                    if (a > b)
//                        a = a - b;
//                    else
//                        b = b - a;
//                }
//                return tempa*tempb/a;
//            }
//        };
//
//        List<Integer> result = IntStream.range(0, l1.size()).
//                mapToObj(i -> findLCM.apply(l1.get(i), l2.get(i))).
//                collect(Collectors.toList());
//        System.out.println(result);

        // lcm using higher order bifunction
        List<Integer> l1 = Arrays.asList(15, 343, 12, 20);
        List<Integer> l2 = Arrays.asList(25, 7, 28, 32);

        BiFunction<Integer, Integer, Integer> findGCD = new BiFunction<>(){
            @Override
            public Integer apply(Integer a, Integer b){
                if(b == 0) return a;
                return apply(b, a%b);
            }
        };
        BiFunction<BiFunction<Integer, Integer, Integer>, Integer, Integer> findLCM =
                (func, i) -> {
                    return (l1.get(i)*l2.get(i))/func.apply(l1.get(i), l2.get(i));
                };
        List<Integer> result = IntStream.range(0, l1.size()).
                mapToObj(i -> findLCM.apply(findGCD, i)).
                collect(Collectors.toList());
        System.out.println(result);

    }
}
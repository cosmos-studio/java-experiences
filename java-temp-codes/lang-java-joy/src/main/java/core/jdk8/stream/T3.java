package core.jdk8.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T3 {
    public static void main(String[] args) {
        int[] list = {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        System.out.println(Arrays.stream(list).mapToObj(i -> i + ", ").reduce((a, b)->a+b).get());
        System.out.println(Arrays.stream(list).mapToObj(i -> i + "").collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(list).sorted().mapToObj(i -> i + ",").reduce((a,b) -> a + b).get());

        System.out.println("Last one : " + Arrays.stream(list).reduce((a,b) -> b).getAsInt());
        System.out.println("Last one : " + Arrays.stream(list).skip(list.length - 1).findAny().getAsInt());

        Arrays.stream(list).boxed().map(e -> e + ",").forEach(System.out::print);
        System.out.println();

        IntStream.of(1, 2, 3, 4, 5).filter(e -> e>2).peek(e -> System.out.println("Filtered value: " + e))
                .map(e -> e*e).peek(e -> System.out.println("Mapped value : " + e)).count();

        System.out.println(String.join("-", "a", "b"));
        System.out.println(Arrays.asList(1, 2, 3, 4).stream().collect(Collectors.partitioningBy(e -> e>2)).values());

        System.out.println(Math.pow(3,3));
    }
}

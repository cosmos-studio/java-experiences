package core.jdk8.stream;

import java.util.Arrays;

public class T4 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(sumByFor(array));
        System.out.println(sumByWhile(array));
        System.out.println(sumByLambda(array));
        System.out.println(sumByRecursion(array.clone()));
    }

    public static int sumByFor(int[] array) {
        int sum = 0;
        for(int item : array) {
            sum += item;
        }
        return sum;
    }

    public static int sumByWhile(int[] array) {
        int sum = 0;
        int i = 0;
        while(i < array.length) {
            sum += array[i++];
        }
        return sum;
    }

    public static int sumByRecursion(int[] array) {
        return recursition(array)[0];
    }

    private static int[] recursition(int[] array) {
        if(array.length == 1) {
            return new int[] {array[0]};
        } else {
            array[0] += array[array.length - 1];
            return recursition(Arrays.copyOf(array, array.length - 1));
        }
    }

    public static int sumByLambda(int[] array) {
        int sum = Arrays.stream(array).sum();
        Arrays.stream(array).mapToObj(i -> i + ", ").forEach(System.out::print);
        return sum;
    }
}

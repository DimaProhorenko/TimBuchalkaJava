package expressions;
import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Alpha", "Bravo", "Charlie", "Delta"
        ));

//        list.forEach(System.out::println);
//        int result = calculator((a, b) -> a + b, 5, 2);
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2385},
                new double[]{75.9504, -90.4892},
                new double[]{39.0929, -37.4839},
                new double[]{94.5840, -29.6950}
        );

//        coords.forEach(c -> System.out.println(Arrays.toString(c)));

        BiConsumer<Double, Double> c = (lat, lng) -> {
            System.out.printf("Latitude: %.3f, Longitude: %.3f\n", lat, lng);
        };
        coords.forEach(item -> proccessPoint(item[0], item[1], c));
    }

    public static <T> T calculator(Operation<T> function, T t1, T t2) {
        T result = function.operate(t1, t2);
        System.out.println("Result: " + result);
        return result;
    }

    public static <T> void proccessPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}

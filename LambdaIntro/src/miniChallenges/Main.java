package miniChallenges;
import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printString = el -> {
            System.out.println(Arrays.toString(el.split(" ")));
        };


        printString.accept("Hello java is cool. I love it");

        Consumer<String> printWordsForEach = el -> {
            String[] words = el.split(" ");
            Arrays.asList(words).forEach(word -> System.out.println(word));
        };

        printWordsForEach.accept("Hello java is cool, and I love working with it");

        Consumer<String> printWordsConcise = el -> {
            Arrays.asList(el.split(" ")).forEach(System.out::println);
        };
        printWordsConcise.accept("Split this string into words and print it to the console.");
    }
}

package com.dima;
import java.util.Arrays;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        String name = "Dima";
        Function<String, String> uCase = String::toUpperCase;
        Function<String, String> addLastName = s -> s.concat(" Last Name");
        Function<String, String> uCaseLastName = uCase.andThen(addLastName);
//        System.out.println(uCaseLastName.apply(name));

        Function<String, String[]> f0 = uCase.
                andThen(s -> s.concat(" LastName")).
                andThen(s -> s.split(" "));

//        System.out.println(Arrays.toString(f0.apply("Dima")));

        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" LastName"))
                .andThen(s -> s.split(" "))
                .andThen(arr -> arr[1].toUpperCase() + ", " + arr[0]);

//        System.out.println(f1.apply("Dima"));

        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" LastName"))
                .andThen(s -> s.split(" "))
                .andThen(arr -> String.join(", ", arr))
                .andThen(String::length);

        System.out.println(f2.apply("Dima"));


    }
}

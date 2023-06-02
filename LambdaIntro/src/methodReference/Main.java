package methodReference;
import java.util.Arrays;
import java.util.function.*;

class PlainOld {
    private static int lastId = 1;
    private int id = 0;
    public PlainOld() {
        id = PlainOld.lastId++;
        System.out.printf("Creating PlainOld(id = %d)%n", id);
    }
}

public class Main {
    public static void main(String[] args) {
//        calculator(Integer::sum, 10, 5);
//        calculator(Double::sum, 2.5, 7.5);
//        Supplier<PlainOld> poSupplier = PlainOld::new;
//        seedArray(PlainOld::new, 10);
        calculator(String::concat, "Hello", " world");
        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
//        UnaryOperator<String> u1 = String::concat; won't work
    }

    private static <T> void calculator(BinaryOperator<T> function, T t1, T t2) {
        System.out.println(function.apply(t1, t2));
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> supplier, int count) {
        PlainOld[] po = new PlainOld[count];
        Arrays.setAll(po, i -> supplier.get());
        return po;
    }
}

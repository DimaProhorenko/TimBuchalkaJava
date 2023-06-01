package challenge;
import java.util.*;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of(
                "Dima",
                "NasTyA",
                "jerome",
                "Andrew",
                "Bob",
                "mike",
                "sAm"
        ));

        names.replaceAll(name -> name.toUpperCase() + " " + generateRandomChar() + ".");
        names.replaceAll(name -> name + getReversedString(name.substring(0, name.indexOf('.') - 1)));
        names.removeIf(name -> name.split(" ")[0].equalsIgnoreCase(name.split(" ")[2]));
        System.out.println(names);
    }


    public static char generateRandomChar() {
        return (char) random.nextInt(65, 91);
    }

    public static String getReversedString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

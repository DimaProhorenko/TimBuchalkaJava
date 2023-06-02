package challenge2;
import java.util.*;
import java.util.function.*;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String[] names = {
                "Dima",
                "jack",
                "dorothy",
                "Samuel",
                "Max",
                "miles"
        };

        List<UnaryOperator<String>> operators = new ArrayList<>(List.of(
                String::toUpperCase,
                Main::addMiddleInitial,
                Main::addLastName
        ));

        System.out.println(applyChanges(operators, names));
        System.out.println(Arrays.toString(names));

    }

    private static char getRandomChar() {
        return (char) random.nextInt(65, 91);
    }

    private static String addMiddleInitial(String s) {
        return s.concat(" " + getRandomChar() + ".");
    }

    private static String addLastName(String s) {
        return s.concat(getReversedString(s.substring(0, s.indexOf(".") -1)));
    }

    private static String getReversedString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static List<String> applyChanges(List<UnaryOperator<String>> operators, String[] arr) {
        List<String> backedByArray = Arrays.asList(arr);
        for (UnaryOperator function : operators) {
            backedByArray.replaceAll(function);
        }
        return backedByArray;
    }
}

package miniChallenges;
import java.util.function.UnaryOperator;
import java.util.function.Supplier;
public class Challenge2 {
    public static void main(String[] args) {
        UnaryOperator<String> uo = el -> {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < el.length(); i++) {
                if(i % 2 == 1) {
                    sb.append(el.charAt(i));
                }
            }
            return sb.toString();
        };

//        System.out.println(everySecondChar(uo,"1234567890"));
        Supplier<String> supplierOfLove = () -> "I love java";
        String iLoveJava = supplierOfLove.get();
        System.out.println(iLoveJava);
    }

    public static <T> T everySecondChar(UnaryOperator<T> uo, T t) {
        return uo.apply(t);
    }
}

package challenge.util;
import java.util.*;
public class QueryList<T extends QueryItem> extends ArrayList<T> {

    public QueryList(List<T> items) {
        super(items);
    }

    public QueryList() {

    }

    public static <T extends QueryItem> QueryList<T> getMatches(List<T> items, String field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (T item : items) {
            if(item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }

        return matches;
    }

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (T item : this) {
            if(item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }

        return matches;
    }
}

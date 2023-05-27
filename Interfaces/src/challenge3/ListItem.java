package challenge3;

import java.util.ListIterator;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    protected abstract ListItem next();

    protected abstract ListItem setNext(ListItem nextItem);

    protected abstract ListItem previous();

    protected  abstract  ListItem setPrevious(ListItem prevItem);

    protected int compareTo(ListItem itemToCompareWith) {
        return String.valueOf(this).compareTo(String.valueOf(itemToCompareWith));
    }
}

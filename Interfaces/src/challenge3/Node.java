package challenge3;

import java.util.List;

public class Node extends ListItem{

    Node(Object value) {
        super(value);
    }

    protected ListItem next() {
        return rightLink;
    }

    protected ListItem setNext(ListItem nextItem) {
        rightLink = nextItem;
        return rightLink;
    }

    protected ListItem previous() {
        return leftLink;
    }

    protected ListItem setPrevious(ListItem prevItem) {
        leftLink = prevItem;
        return leftLink;
    }
}

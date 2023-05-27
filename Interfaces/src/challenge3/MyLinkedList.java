package challenge3;

public class MyLinkedList implements NodeList {
    ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(item == null || root.compareTo(item) == 0) {
            return false;
        }
        root.setNext(item);
        return true;
    }

    @Override
    public boolean removeItem() {
        return false;
    }

    @Override
    public void traverse() {
        if(root.rightLink != null) {
            System.out.println(root.rightLink.value);
            traverse();
        }
    }
}

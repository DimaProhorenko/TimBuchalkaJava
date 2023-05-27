package challenge3;

public class Main {
    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList(new Node("First -> middle"));
        ml.addItem(new Node("First -> right"));
        ml.traverse();
    }
}

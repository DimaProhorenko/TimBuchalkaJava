public class Main {
    public static void main(String[] args) {
        MobilePhone mp = new MobilePhone("0932110492");
        Contact me = new Contact("Dima", "1234");
        Contact jeremy = new Contact("Jeremy", "555666");

        mp.addNewContact(me);
        mp.addNewContact(me);
        mp.addNewContact(jeremy);
        mp.printContacts();

        mp.updateContact(me, new Contact("Dimasik", "9876"));
        mp.removeContact(jeremy);
        mp.printContacts();
    }
}

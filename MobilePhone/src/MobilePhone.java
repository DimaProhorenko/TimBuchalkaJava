import java.util.List;
import java.util.ArrayList;
public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact contactToUpdate, Contact newContact) {
        int index = findContact(contactToUpdate);
        if(index >= 0) {
            myContacts.set(index, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contactToRemove) {
        int index = findContact(contactToRemove);
        if(index >= 0) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if(index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for(int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);
            System.out.printf("%d. %s -> %s\n", i + 1, c.getName(), c.getPhoneNumber());
        }
    }



    private int findContact(Contact contact) {
        int result = -1;
        for(int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);
            if(c.getName().equalsIgnoreCase(contact.getName())) {
                result = i;
                break;
            }
        }

        return result;
    }

    private int findContact(String name) {
        return findContact(new Contact(name, "Dummy phone number"));
    }
}

package Collections.ListsAndArrays.Challange.MobilePhoneChallange;

public class Contact {
    private String name;
    private String phoneNumber;

    Contact(String name, String phoneNumber){
        this.name = name; 
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }
}

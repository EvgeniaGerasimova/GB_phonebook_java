import java.util.*;

class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public void printSortedPhoneBook() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        entries.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        
        phoneBook.addContact("Олег", "+7(987)654-32-10");
        phoneBook.addContact("Кристина", "+7(345)678-90-12");
        phoneBook.addContact("Олег", "+7(234)567-89-01");
        phoneBook.addContact("Елена", "+7(345)678-90-12");
        phoneBook.addContact("Василий", "+7(346)678-90-12");
        phoneBook.addContact("Василий", "+7(111)222-33-33");

       
        phoneBook.printSortedPhoneBook();
    }
}

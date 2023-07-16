package Seminar05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            List<String> data = phoneBook.get(name);
            data.add(phone);
        }
        else {
            List<String> data = new ArrayList<>();
            data.add(phone);
            phoneBook.put(name, data);
        }        
    }

    void addPhone(String name, String phone) {
        add(name, phone);        
    }

    void printPhoneBook() {
        System.out.println(phoneBook.entrySet());
    }

    void remove(String name) {
        phoneBook.remove(name);
        
    }
}

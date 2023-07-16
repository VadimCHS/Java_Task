// 1. Реализуйте структуру телефонной книги с помощью HashMap, 
//    учитывая, что 1 человек может иметь несколько телефонов.

package Seminar05;

public class Task1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();                  // Создание справочника
        phoneBook.add("Петр", "82365902165");        // Добавление контакта
        phoneBook.add("Кристина", "82334630216");
        phoneBook.add("Сергей", "82231467457");
        phoneBook.addPhone("Петр", "8236590216");    // Добавление номера контакта
        phoneBook.add("Марина", "8268952827");
        phoneBook.add("Иван", "82313462854");
        phoneBook.printPhoneBook();                             // Вывод справочника
        phoneBook.remove("Марина");                        // Удаление контакта
        phoneBook.printPhoneBook();                             // Вывод справочника
    }
}

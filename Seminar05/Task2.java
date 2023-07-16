// 2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, 
//    Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, 
//    Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, 
//    Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, 
//    Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет 
//    повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности. 
//    Для сортировки использовать TreeMap.


package Seminar05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {
    public static void main(String[] args) {
        String people = "Иван Иванов, Светлана Петрова,\n" +
                    "Кристина Белова, Анна Мусина,\n"  +
                    "Анна Крутова, Иван Юрин, Петр Лыков,\n" +
                    "Павел Чернов, Петр Чернышов,\n" +
                    "Мария Федорова, Марина Светлова,\n" +
                    "Мария Савина, Мария Рыкова,\n" +
                    "Марина Лугова, Анна Владимирова,\n" +
                    "Иван Мечников, Петр Петин, Иван Ежов.";
        
        countName(people);
        
    }

    static void countName (String people) {
        Map<String, List<String>> map = new HashMap<>();                            // Вспомогательный словарь
        Map<Integer, List<String>> tree = new TreeMap<>(Comparator.reverseOrder()); // Словарь для сортировки
        people.replace(".", "");
        people.replace("\n", " ");

        String[] words = people.split(",");

        for (String string : words) {                               // Заполняем вспомогательный словарь
            String[] data = string.trim().split(" ");
            String name = data[0];
            String surname = data[1];
            if (map.containsKey(name)) {
                List<String> list1 = map.get(name);
                list1.add(surname);
            }
            else{
                List<String> listSurname = new ArrayList<>();
                listSurname.add(surname);
                map.put(name, listSurname);
                
            }
        }

        for (String string : map.keySet()) {                        // Заполняем словарь для сортировки
            int len = map.get(string).size();
            if (tree.containsKey(len)) {
                List<String> list1 = tree.get(len);
                list1.add(string);
            }
            else {
                List<String> list1 = new ArrayList<>();
                list1.add(string);
                tree.put(len, list1);
            }
            
        }
        
        System.out.println(tree.entrySet());                        // Вывод результата
    }    
}

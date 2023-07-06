// 3. Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. 
//    Вывести название каждой планеты и количество его повторений в списке. 
//    Collections.frequency(list, item)

package Seminar03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int sizeList = 15;
        String[] planets = {"Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун"};

        List<String> listPlanets = new ArrayList<>();
        listPlanets = fiilingList(planets, sizeList);
        System.out.println(listPlanets);

        printList(listPlanets);
    }

    static List<String> fiilingList(String[] string, int sizeList) {
        List<String> result = new ArrayList<>(sizeList);
        for (int i = 0; i < sizeList; i++)
            result.add(string[new Random().nextInt(string.length)]);
        return result;
    }

    static void printList(List<String> list) {
        for (String string : list)
            System.out.println(string + " : " + Collections.frequency(list, string));
    }
}

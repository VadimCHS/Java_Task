// 2. Задан целочисленный список ArrayList. 
//    Найти минимальное, максимальное и среднее арифметическое из этого списка. 
//    Collections.max()

package Seminar03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(new Random().nextInt(20));

        System.out.println("Список:" + list);

        System.out.println("Max: " + valueMax(list));
        System.out.println("Min: " + valueMin(list));
        System.out.println("Average: " + average(list));
    }

    static int valueMax(List<Integer> list) {
        return Collections.max(list);
    }

    static int valueMin(List<Integer> list) {
        return Collections.min(list);
    }

    static double average(List<Integer> list) {
        double result = 0;
        for (Integer number : list)
            result += number;
        return result / list.size();
    }
}

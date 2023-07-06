// 1. Пусть дан произвольный список целых чисел, удалить из него четные числа.

package Seminar03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            list.add(new Random().nextInt(100));
        System.out.println(list);
        System.out.println(removeEvenNum(list));    
    }

    static List<Integer> removeEvenNum(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            if (number%2 != 0)
                result.add(number);
        }
        return result;
    }

}

// 1. Пусть дан LinkedList с несколькими элементами. 
//    Реализуйте метод, который вернет “перевернутый” список. Постараться не обращаться к листу по индексам.
// 2. Реализуйте очередь с помощью LinkedList со следующими методами: 
//    enqueue() - помещает элемент в конец очереди, 
//    dequeue() - возвращает первый элемент из очереди и удаляет его, 
//    first() - возвращает первый элемент из очереди, не удаляя.
// 3. Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор

package Seminar04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Task {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();                    // Создание списка чисел
        for (int i = 0; i < 5; i++)
            list.add(new Random().nextInt(10));                     // Заполнение списка
        System.out.println("Начальный список: " + list);                  // Ввыод начального списка
        System.out.println("Развернутый список: " + reverseList(list));   // Вывод развернутого списка
        System.out.println("Начальный список: " + list);                  // Проверка начального списка

        System.out.println("Сумма элементов: " + sumList(list));          // Сумма элементов списка
        System.out.println("Начальный список: " + list);                  // Проверка начального списка   

        MyQueueList<Integer> list3 = new MyQueueList<>();                 // Создание очереди
        list3.enqueue(1);                                         // Добавление в конец очереди
        list3.enqueue(2);                                         // Добавление в конец очереди
        list3.enqueue(3);                                         // Добавление в конец очереди
        System.out.println("Вывод с удалением: " + list3.dequeue());      // Вывод первого элемента и удаление его
        list3.enqueue(4);                                         // Добавление в конец очереди
        while(list3.first() != null) {
            System.out.println("Вывод: " + list3.first());                // Вывод первого элемента без удаления
            System.out.println("Вывод с удалением: " + list3.dequeue());  // Вывод первого элемента и удаление его
        }
    }

    static <E> LinkedList<E> reverseList(LinkedList<E> list) {
        LinkedList<E> result = new LinkedList<>();
        for (E string : list) {
            result.addFirst(string);
        }
        return result;
    }

    static int sumList(LinkedList<Integer> list) {
        int result = 0;
        if (list.isEmpty())
            return result;
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            result += iter.next();
        }
        return result;
    }
}

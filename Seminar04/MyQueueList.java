package Seminar04;

import java.util.LinkedList;

public class MyQueueList<E> {
    private LinkedList<E> list;

    MyQueueList() {
        list = new LinkedList<>();
    }
    
    void enqueue(E element) {
        list.add(element);
    }

    String dequeue() {
        if (list.isEmpty())
            return null;
        return list.removeFirst().toString();
    }

    String first() {
        if (list.isEmpty())
            return null;
        return list.getFirst().toString();
    }
}

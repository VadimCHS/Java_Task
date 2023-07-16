// 3. *Реализовать алгоритм пирамидальной сортировки (HeapSort)

package Seminar05;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(20);
        }

        print(array, "Изначальный массив: ");

        sort(array);

        print(array, "Отсортированный массив: ");      
    }

    static void sort(int[] array) {
        int size = array.length;

        for (int index = size / 2; index >= 0; index--)
            heapify(array, size, index);

        for (int index = size - 1; index >= 0; index--) {
            swap(array, index, 0);
            heapify(array, index, 0);
        }
    }

    static void heapify(int[] array, int size, int indexTop) {
        int top = indexTop;
        int left = 2 * indexTop + 1;
        int right = 2 * indexTop + 2;

        if (left < size && array[left] > array[top]) {
            top = left;
        }
        if (right < size && array[right] > array[top]) {
            top = right;
        }
        if (top != indexTop) {
            swap(array, top, indexTop);
            heapify(array, size, top);
        }               
    }
    
    static void print(int[] a, String mas) {
        System.out.print(mas + ": [ ");

        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println("]");
        
    }

    static void swap(int[] array, int indexOne, int indexTwo) {
        int swap = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swap;
    }
}


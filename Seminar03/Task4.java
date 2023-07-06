// 4. *Реализовать алгоритм сортировки слиянием

package Seminar03;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int[] test = new int[10];

        for (int i = 0; i < test.length; i++)
            test[i] = new Random().nextInt(10);
        System.out.println("Не отсортированный массив: ");
        System.out.println(Arrays.toString(test));
        
        test = sortMerge(test);
        
        System.out.println();
        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(test));
    }

    static int[] sortMerge(int[] arr) {
        if (arr == null)
            return null;

        if (arr.length < 2)
            return arr;

        int[] arrLeft = new int[arr.length / 2];
        System.arraycopy(arr, 0, arrLeft, 0, arrLeft.length);

        int[] arrRight = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, arrRight, 0, arrRight.length);

        arrLeft = sortMerge(arrLeft);
        arrRight = sortMerge(arrRight);

        return mergeArr(arrLeft, arrRight);
    }

    static int[] mergeArr(int[] arrLeft, int[] arrRight) {
        int[] result = new int[arrLeft.length + arrRight.length];
        int posLeft = 0, posRight = 0;

        for (int i = 0; i < result.length; i++) {
            if (posLeft < arrLeft.length && (posRight >= arrRight.length || arrLeft[posLeft] < arrRight[posRight])) 
                result[i] = arrLeft[posLeft++];
            else 
                result[i] = arrRight[posRight++];
        }
        return result;
    }
}


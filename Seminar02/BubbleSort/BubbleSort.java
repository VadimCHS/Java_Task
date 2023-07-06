package Seminar02.BubbleSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class BubbleSort {
    static String log = "C:\\Users\\1\\Desktop\\GB\\Java_Task\\Seminar02\\BubbleSort\\log.txt";
    static Logger logger;

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) 
            arr[i] = new Random().nextInt(20);

        System.out.println("Не отсортированный массив: ");
        System.out.println(Arrays.toString(arr));

        creatLogger();
        arr = bubbleSort(arr);
        closeLogger();


        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(arr));
    }

    private static int[] bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;                        
                }
                logger.info(Arrays.toString(arr));
            }
            length -= 1;            
        }         
        return arr;
    }

    static void closeLogger() {
        for (Handler handler : logger.getHandlers()) {
            handler.close();
        }
    }

    static void creatLogger() {
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(log);
            fileHandler.setEncoding("UTF-8");
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

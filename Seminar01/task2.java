// 2) Вывести все простые числа от 1 до 1000

package Seminar01;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        int number = getNumber("Введите число: ");
        System.out.printf("Простые числа от 1 до %d: \n", number);
        for (int i = 1; i < number; i++) {
            if (primeNumber(i))
                System.out.println(i);
        }
    }

    public static int getNumber(String massage) {
        int result = 0;
        Scanner isScanner = new Scanner(System.in);
        System.out.print(massage);
        if (isScanner.hasNextInt()) {
            result = isScanner.nextInt();
        } else {
            System.out.println("Некорректный ввод. Попробуйте еще раз.");
            isScanner.next();
            result = getNumber(massage);
        }
        isScanner.close();
        return result;
    }

    public static boolean primeNumber(int number) {
        int count = 1;

        if (number == 0)
            return false;
        else if (number == 1)
            return true;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0)
                count++;
        }
        
        if (count > 2)
            return false;
        return true;
    }
}

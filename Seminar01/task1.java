// 1)   Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
//      n! (произведение чисел от 1 до n)

package Seminar01;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        int number = getNumber("Введите число: ");
        System.out.printf("n-ое треугольного числа %d = %d \n", number, triangleNumber(number));
        System.out.printf("Факториал числа %d = %d \n", number, factorial(number));
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

    public static int factorial(int number) {
        if (number <= 1)
            return 1;
        return (number * factorial(number - 1));
    }

    public static int triangleNumber(int number) {
        return (int)((double) number / 2 * (number + 1));
    }
}

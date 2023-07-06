// 3) Реализовать простой калькулятор

package Seminar01;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        double[] numbers = new double[2];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = getNumber("Введите число " + (i + 1) + ": ");
        }
        char simbol = getOperation("Введите операцию: ");
        System.out.println("Результат: " + calculetade(numbers, simbol));
    }

    public static double getNumber(String massage) {
        double result = 0;
        Scanner isScanner = new Scanner(System.in);
        System.out.print(massage);
        if (isScanner.hasNextDouble()) {
            result = isScanner.nextDouble();
        } else {
            System.out.println("Некорректный ввод. Попробуйте еще раз.");
            isScanner.next();
            result = getNumber(massage);
        }
        // isScanner.close();
        return result;
    }

    public static char getOperation(String massage) {
        char result;
        Scanner isScanner = new Scanner(System.in);
        System.out.print(massage);
        if(isScanner.hasNext()){
            result = isScanner.next().charAt(0);
        } else {
            System.out.println("Некорректный ввод. Попробуйте еще раз.");
            isScanner.next();
            result = getOperation(massage);
        }
        // isScanner.close();
        return result;
    }

    public static double calculetade(double[] numbers, char simbol) {
        double result = numbers[0];
        switch (simbol) {
            case '+':
                for (int i = 1; i < numbers.length; i++) {
                    result += numbers[i];
                }
                return result;
            case '-':
                for (int i = 1; i < numbers.length; i++) {
                    result -= numbers[i];
                }
                return result;
            case '*':
                for (int i = 1; i < numbers.length; i++) {
                    result *= numbers[i];
                }
                return result;
            case '/':
                for (int i = 1; i < numbers.length; i++) {
                    result /= numbers[i];
                }
                return result;
            default:
                break;
        }
        return result;
    }
}

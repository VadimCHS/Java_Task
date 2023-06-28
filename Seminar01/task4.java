// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. Предложить хотя бы 
// одно решение или сообщить, что его нет.

package Seminar01;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        String equation = getString("Введите уравнение вида q? + ?w = e: ");
        System.out.println("Решение: " + equationSolution(equation));

    }
    
    public static String getString(String massage) {
        String result = "";
        Scanner isScanner = new Scanner(System.in);
        System.out.print(massage);
        result = isScanner.nextLine();
        isScanner.close();
        return result;
    }
    
    
    public static String equationSolution(String equation) {
        String result = "";
        result = equation.replace(" ", "");
        String[] arr = result.split("[+=]");
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (Integer.parseInt(arr[0].replace('?', (char) (i + 48))) +
                    Integer.parseInt(arr[1].replace('?', (char) (j + 48))) == 
                    Integer.parseInt(arr[2])) {
                    result = arr[0].replace('?', (char) (i + 48)) + 
                             " + " +
                             arr[1].replace('?', (char) (j + 48)) + 
                             " = " + arr[2];
                    return result;
                }
            }
        }
        return "Решения нет.";
    }

}

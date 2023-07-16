package Seminar05;

import java.util.Random;

public class Chess {
    private int blackCount;  // Кол-во черных ферзей
    private int whiteCount;  // Кол-во белых ферзей
    private int varibale;    // Дополнительная переменная

    Chess() {
        this.blackCount = 4;
        this.whiteCount = 4;
        this.varibale = 0;
    }

    Chess(int blackCount, int whiteCount) {
        this.blackCount = blackCount;
        this.whiteCount = whiteCount;
        this.varibale = 0;
    }

    public char[][] ranking(char[][] boardChees) {
        checkCountBlackWhite(boardChees);
        int[] count = {0, 0};                            // Установленных Ч и Б = 0
        return ranking(boardChees, count);
    }

    private char[][] ranking(char[][] boardChees, int[] count) {
        char[] color = {'Ч', 'Б'};
        int random = 0;
        for (int i = 0; i < boardChees[0].length; i++) {
            for (int j = 0; j < boardChees[1].length; j++) {
                if (boardChees[i][j] == '.') {
                    if((count[0] + varibale + count[1]) == 8)   // Проверка общей суммы установленных фигур
                        return boardChees;
                    if(count[0] == this.blackCount)             // Проверка кол-ва установленных Ч
                        random = 1;
                    if(count[1] == this.whiteCount)             // Проверка кол-ва установленных Б
                        random = 0;
                    if(count[0] < this.blackCount && count[1] < this.whiteCount)
                        random = new Random().nextInt(2); // Случайный выбор установки Ч или Б
                    boardChees[i][j] = color[random];
                    count[random]++;
                    if (check(boardChees, i, j, color[random])) {  // Проверка установленной фигуры
                        ranking(boardChees, count);                // Проверка всех вариантов в глубину        
                    } 
                    if(!check(boardChees, i, j, color[random])) {
                        count[random]--;
                        boardChees[i][j] = '.'; 
                    }                    
                }
            }
        }
        return boardChees;
    }


    private boolean check(char[][] arr, int indexA, int indexB, char color) {
        char check = ' ';
        if(color == 'Ч')
            check = 'Б';
        if (color == 'Б')
            check = 'Ч';

        for (int i = 0; i < arr.length; i++) {                               // Проверка фигуры по вертикали
            if (arr[indexA][i] == check && i != indexB) {
                return false;
            }
        }

        for (int i = 0; i < arr.length; i++) {                               // Проверка фигуры по горизонтали
            if (arr[i][indexB] == check && i != indexA) {
                return false;
            }
        }
        
        for (int i = indexA - 1, j = indexB - 1; i >= 0 && j >= 0; i--, j--) {      // Проверка фигуры по диагонали
            if (arr[i][j] == check) {
                return false;
            }
        }

        for (int i = indexA + 1, j = indexB - 1; i < arr.length && j >= 0; i++, j--) { // Проверка фигуры по диагонали
            if (arr[i][j] == check) {
                return false;
            }
        }

        for (int i = indexA - 1, j = indexB + 1; i >= 0  && j < arr.length; i--, j++) { // Проверка фигуры по диагонали
            if (arr[i][j] == check) {
                return false;
            }
        }

        for (int i = indexA + 1, j = indexB + 1; i < arr.length && j < arr.length; i++, j++) { // Проверка фигуры по диагонали
            if (arr[i][j] == check) {
                return false;
            }
        }
        return true;
    }

    private void checkCountBlackWhite(char[][] arr){
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                if (arr[i][j] == 'Ч' && this.blackCount != 0){
                    this.blackCount--;
                    this.varibale++; 
                }
                if (arr[i][j] == 'Б' && this.whiteCount != 0) {
                    this.whiteCount--;
                    this.varibale++;
                }
            }
        }
    }
    
}
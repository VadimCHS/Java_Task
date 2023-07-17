package Chess;

public class Chess {
   
    public char[][] ranking(char[][] boardChees) {
        ranking(boardChees, checkCountBlackWhite(boardChees));
        if (checkCountBlackWhite(boardChees) > 0){
            System.out.println("Решения нет");
            return null;
        }
        return boardChees;
    }

    private char[][] ranking(char[][] boardChees, int count) {
        char shape = 'Ф';
        for (int i = 0; i < boardChees[0].length; i++) {
            for (int j = 0; j < boardChees[1].length; j++) {
                if (boardChees[i][j] == '.') {
                    boolean check = check(boardChees, i, j);
                    // System.out.println("--------------------------");
                    // print(boardChees);
                    if (check) {
                        boardChees[i][j] = shape;
                        count--;

                        if (ranking(boardChees, count) != null) {
                            return boardChees;
                        }
                        boardChees[i][j] = '.';
                        count++;
                    }                    
                }
            }
        }
        if (count == 0) {
            return boardChees;
        }
        return null;
    }


    private boolean check(char[][] arr, int indexA, int indexB) {
        char check = 'Ф';

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

    private int checkCountBlackWhite(char[][] arr){
        int res = 8;
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                if (arr[i][j] == 'Ф'){
                    if (!check(arr, i, j)) {
                        System.out.println("Решения нет!");
                        return 0;
                    }
                    res--;
                    
                }                 
            }
        }
        if (res == 0) {
            System.out.println("Расставлены все фигуры");
            return 0;
        }
        return res;
    }

    private void print(char[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                System.out.print(arr[i][j] + "  ");                
            }
            System.out.println();
        }
    }
    
}

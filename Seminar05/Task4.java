// 4. **На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package Seminar05;
  
public class Task4 {
    public static void main(String[] args) {
        int blackCount = 4;                                         // Кол-во черных ферзей
        int whiteCount = 4;                                         // Кол-во белых ферзей
        char[][] board = {{'.', '.', '.', '.','.', '.', '.', '.'},  // Шахматная доска
                          {'.', '.', '.', '.','.', '.', '.', '.'},  // Для растановки своих ферзей
                          {'.', '.', '.', '.','.', '.', '.', '.'},  // Замените '.' на 'Ч' или 'Б'
                          {'.', '.', '.', '.','.', '.', '.', '.'},  // Сумма Ч и Б не должна превышать 8
                          {'.', '.', '.', '.','.', '.', '.', '.'},  
                          {'.', '.', '.', '.','.', '.', '.', '.'},  
                          {'.', '.', '.', '.','.', '.', '.', '.'},
                          {'.', '.', '.', '.','.', '.', '.', '.'}};

        print(board);

        Chess chess = new Chess(blackCount, whiteCount);
        chess.ranking(board);

        print(board);
    }

    static void print(char[][] a) {
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a[1].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
}

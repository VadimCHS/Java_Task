package Chess;

public class main {
    public static void main(String[] args) {
        // Для свой расстановки замените '.' на 'Ф' но не более 8
        char[][] board = {{'.', 'Ф', '.', '.','.', '.', '.', '.'},
                          {'.', '.', '.', '.','.', '.', '.', '.'}, 
                          {'.', '.', '.', '.','.', '.', '.', '.'}, 
                          {'.', '.', '.', '.','.', '.', '.', '.'},  
                          {'.', '.', '.', '.','.', '.', '.', '.'},  
                          {'.', '.', '.', '.','.', '.', '.', '.'},  
                          {'.', '.', '.', '.','.', '.', '.', '.'},
                          {'.', '.', '.', '.','.', '.', '.', '.'}};

        print(board);

        Chess chess = new Chess();
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
        System.out.println();
    }
}

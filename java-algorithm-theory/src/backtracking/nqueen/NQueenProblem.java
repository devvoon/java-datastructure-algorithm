package backtracking.nqueen;

import java.util.Arrays;

public class NQueenProblem {

    final int N = 4;
    
    public static void main(String[] args) {
        NQueenProblem queen = new NQueenProblem();
        queen.solve();
    }
    
    boolean solve() {
//        int board[][] = { { 0, 0, 0, 0},
//                          { 0, 0, 0, 0},
//                          { 0, 0, 0, 0},
//                          { 0, 0, 0, 0} } ;

        int board[][] = new int[N][N];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i],0);
        }
        
        if (dfs(board, 0) == false) {
            System.out.println("해닶 없음 ");
            return false;
        }
        
        print(board);
        return true;
    }

    private boolean dfs(int[][] board, int col) {
        
        // 모든 퀸이 자리 잡았으면 종료
        if (col >= N) {
            return true;
        }
        
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                
                if (dfs(board, col +1)){
                    return true;
                }
                
                board[i][col] = 0;
            }
        }
        
        return false;
    }
    
    private boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        
        for (i = 0; i < col; i++) {
            
            // 해당 row
            if (board[row][i] == 1) {
                return false;
            }
            
            for (i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            
            for (i = row, j = col; j >= 0 && i < N; i++, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private void print(int[][] board) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print( " " + board[i][j] + " ");
            }
            System.out.println();
        }
        
    }

}

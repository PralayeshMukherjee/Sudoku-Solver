public class Sudoku{
    public boolean isSafe(char[][] board, int row, int col, int number) {
        // condition for row & column
        for(int i=0;i<board.length;i++) {
            if(board[i][col] == (char)(number+'0')) {
                return false;
            }
            if(board[row][i] == (char)(number+'0')) {
                return false;
            }
        }
        //condition for grid
        int startingRow = (row/3) * 3;
        int startingCol = (col/3) * 3;

        for(int i = startingRow;i<startingRow+3;i++) {
            for(int j = startingCol; j< startingCol+3; j++) {
                if(board[i][j] == (char)(number+'0')) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][] board,int row, int col) {
        if(row == board.length) {
            return true;
        }//base condition
        int nrow = 0;
        int ncol = 0;
        if(col != board.length-1) {
            nrow = row;
            ncol = col +1;
        } else {
            nrow = row+1;
            ncol = 0;
        }
        if(board[row][col] != '.') {
            if(helper(board, nrow, ncol)) {
                return true;
            }
        } else{
            for(int i=1; i<=9;i++) {
                if(isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i+'0');// because board is char type so we should convert i in char type
                    if(helper(board, nrow, ncol)) {
                        return true;
                    } else{
                        board[row][col] = '.';//if did not return back true then turn board function into null
                    }
                }
            }
        }
        return false;//if function does not return anything
    }
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);

    }
}
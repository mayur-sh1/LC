class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char d='1';d<='9';d++){
                        if(isValid(i,j,d,board)){
                            board[i][j]=d;
                            if(solve(board)) return true;
                            board[i][j]='.';
                        }
                    }
                return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int row,int col,char d,char[][] board){
        for(int i=0;i<9;i++){
            if(board[row][i]==d || board[i][col]==d) return false;
        }

        // box checking
        int start_row=(row/3)*3;
        int start_col=(col/3)*3;

        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(board[start_row+k][start_col+l]==d) return false;
            }
        }
        return true;
    }
}
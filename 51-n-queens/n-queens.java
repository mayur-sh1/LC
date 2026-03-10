class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) board[i][j]='.';
        }

        solve(ans,board,0,n);

        return ans;
    }
    public void solve(List<List<String>> ans,char[][] board,int col,int n){
        if(col==n){
            List<String> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                l.add(new String(board[i]));
            }
            ans.add(l);
            return ;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(ans,board,col+1,n);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(int row,int col,char[][]board,int n){
        int dupRow=row,dupCol=col;

        // upper left diagonal
        while(dupRow>=0 && dupCol>=0){
            if(board[dupRow][dupCol]=='Q') return false;
            dupRow--;
            dupCol--;
        }

        dupRow=row;
        dupCol=col;
        // left side
        while(dupCol>=0){
            if(board[dupRow][dupCol]=='Q') return false;
            dupCol--;
        }
        dupRow=row;
        dupCol=col;

        while(dupRow<n && dupCol>=0){
            if(board[dupRow][dupCol]=='Q') return false;
            dupRow++;
            dupCol--;
        }
        return true;
    }
}
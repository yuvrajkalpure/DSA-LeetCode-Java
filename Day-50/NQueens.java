class NQueens {
    List<List<String>> res;
    char[][] board;
    boolean[] cols,diagMain,diagAnti;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        res=new ArrayList<>();
        board=new char[n][n];
        cols=new boolean[n];
        diagMain=new boolean[2*n];
        diagAnti=new boolean[2*n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        backtrack(0);

        return res;
    }

    private void backtrack(int row){
        if(row==n){
            List<String> solution=new ArrayList<>();
            for(char[] r:board){
                solution.add(new String(r));
            }
            res.add(solution);
            return;
        }

        for(int col=0;col<n;col++){

            int d1=row-col+n;
            int d2=row+col;

            if(cols[col] || diagMain[d1] || diagAnti[d2]){
                continue;
            }

            board[row][col]='Q';
            cols[col]=diagMain[d1]=diagAnti[d2]=true;
            
            backtrack(row+1);

            board[row][col]='.';
            cols[col]=diagMain[d1]=diagAnti[d2]=false;
        }
    }
}
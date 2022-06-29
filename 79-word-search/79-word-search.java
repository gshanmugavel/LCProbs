class Solution {
    char[][] board;
    String word;
    int m, n;
    int len;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private boolean dfs(int i, int j, int ind, boolean vis[][]){
         // System.out.println(i+"-"+j+"-"+ind);
        if(ind >= len){
            return true;
        }
        for(int[] dir : dirs){
            if(isValid(i+dir[0], j+dir[1], ind, vis)){
                vis[i+dir[0]][j+dir[1]] = true;
                if(dfs(i+dir[0], j+dir[1], ind+1, vis)){
                    return true;
                }
                vis[i+dir[0]][j+dir[1]] = false;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.len = word.length();
        this.m = board.length;
        this.n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isValid(i, j, 0, vis)){
                    vis[i][j] = true;
                    if(dfs(i,j,1, vis)){
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean isValid(int i, int j, int ind, boolean vis[][]){
        return i>=0 && i<m && j>=0 && j<n && !vis[i][j] && word.charAt(ind) == board[i][j];
    }
}
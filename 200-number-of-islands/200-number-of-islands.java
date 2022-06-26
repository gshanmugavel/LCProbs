class Solution {
    int m, n;
    boolean vis[][];
    char[][] grid;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        vis = new boolean[m][n];
        for(boolean[] arr : vis){
            Arrays.fill(arr, false);
        }
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                    while(!q.isEmpty()){
                        int[] arr = q.poll();
                        int a = arr[0], b = arr[1];
                        if(isValid(a+1, b)){
                            q.add(new int[]{a+1,b});
                            vis[a+1][b] = true;
                        }
                        if(isValid(a, b+1)){
                            q.add(new int[]{a,b+1});
                            vis[a][b+1] = true;
                        }
                        if(isValid(a-1, b)){
                            q.add(new int[]{a-1,b});
                            vis[a-1][b] = true;
                        }
                        if(isValid(a, b-1)){
                            q.add(new int[]{a,b-1});
                            vis[a][b-1] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
    public boolean isValid(int i, int j){
        return i >= 0 && i < m && j >= 0 && j < n && !vis[i][j] && grid[i][j] == '1';
    }
}
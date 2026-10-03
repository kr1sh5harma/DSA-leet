// leet 200
class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islands = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    islands+=1;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1'){
            return;
        }

        grid[i][j] = '$';
        
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
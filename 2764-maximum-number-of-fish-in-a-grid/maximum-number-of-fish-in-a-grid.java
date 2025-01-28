class Solution {
    private final int[] DIR = new int[]{0,1,0,-1,0};
    public int findMaxFish(int[][] grid) {
        int m=grid.length, n=grid[0].length, res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    res = Math.max(res,dfs(grid,i,j,n,m));
                }
            }
        }
        return res;
    }
    private int dfs(int[][] grid,int r,int c,int n,int m){
        int fish = grid[r][c];
        grid[r][c] = 0;
        for(int k=0;k<4;k++){
            int nr = r + DIR[k], nc = c + DIR[k+1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]>0){
                fish += dfs(grid,nr,nc,n,m);
            }
        }
        return fish;
    }
}
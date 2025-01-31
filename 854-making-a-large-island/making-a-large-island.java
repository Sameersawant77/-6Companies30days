class Solution {
    public int largestIsland(int[][] grid) {
        Map<Integer,Integer> regionsArea = new HashMap<>();
        regionsArea.put(0,0);
        int n = grid.length, region = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area = floodfill(grid,i,j,region,n);
                    regionsArea.put(region,area);
                    region++;
                }
            }
        }
        int max = regionsArea.getOrDefault(2,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> neighbours = new HashSet<>();
                    neighbours.add(i>0?grid[i-1][j]:0);
                    neighbours.add(j>0?grid[i][j-1]:0);
                    neighbours.add(i<n-1?grid[i+1][j]:0);
                    neighbours.add(j<n-1?grid[i][j+1]:0);
                    int area = 1;
                    for(int neighbour : neighbours){
                        area += regionsArea.get(neighbour);
                    }
                    if(area>max){
                        max = area;
                    }
                }
            }
        }
        return max;
    }
    private int floodfill(int[][] grid, int i, int j, int region,int n){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]!=1){
            return 0;
        }
        grid[i][j] = region;
        int sum = 1;
        sum += floodfill(grid,i+1,j,region,n);
        sum += floodfill(grid,i-1,j,region,n);
        sum += floodfill(grid,i,j+1,region,n);
        sum += floodfill(grid,i,j-1,region,n);
        return sum;
    }
}
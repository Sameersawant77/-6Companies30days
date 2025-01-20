class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] valueRow = new int[m*n+1];
        int[] valueCol = new int[m*n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                valueRow[mat[i][j]] = i;
                valueCol[mat[i][j]] = j;
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for(int i=0;i<arr.length;i++){
            int rowIndex = valueRow[arr[i]];
            int colIndex = valueCol[arr[i]];
            rowCount[rowIndex]++;
            colCount[colIndex]++;

            if(rowCount[rowIndex]>=n || colCount[colIndex]>=m){
                return i;
            }
        }
        return arr.length-1;
    }
}
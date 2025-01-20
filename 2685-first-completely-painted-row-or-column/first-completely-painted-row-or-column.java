class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer,int[]> valuesToPos = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                valuesToPos.put(mat[i][j],new int[]{i,j});
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for(int i=0;i<arr.length;i++){
            int[] index = valuesToPos.get(arr[i]);
            rowCount[index[0]]++;
            colCount[index[1]]++;

            if(rowCount[index[0]]>=n || colCount[index[1]]>=m){
                return i;
            }
        }
        return arr.length-1;
    }
}
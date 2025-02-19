class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] frequency = new int[n+1];
        int[] res = new int[n];
        int counter = 0;
        for(int i=0;i<n;i++){
            if(++frequency[A[i]]==2) counter++;
            if(++frequency[B[i]]==2) counter++;
            res[i] = counter;
        }
        return res;
    }
}
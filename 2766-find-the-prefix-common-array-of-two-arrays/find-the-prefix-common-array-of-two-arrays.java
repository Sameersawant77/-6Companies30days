class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] frequency = new int[n];
        int[] res = new int[n];
        int counter = 0;
        for(int i=0;i<n;i++){
            frequency[A[i]-1]++;
            if(frequency[A[i]-1]>=2) counter++;
            frequency[B[i]-1]++;
            if(frequency[B[i]-1]>=2) counter++;
            res[i] = counter;
        }
        return res;
    }
}
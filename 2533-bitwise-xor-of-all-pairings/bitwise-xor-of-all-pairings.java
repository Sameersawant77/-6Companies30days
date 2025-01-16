class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int x = 0, y = 0;
        if((n1&1)==1){
            for(int i=0;i<nums2.length;i++){
                y ^= nums2[i];
            }
        }
        if((n2&1)==1){
            for(int i=0;i<nums1.length;i++){
                x ^= nums1[i];
            }
        }
        return x ^ y;
    }
}
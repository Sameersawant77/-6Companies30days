class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length, res = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                boolean increasing = true;
                int prev = 0;
                for(int k=0;k<n;k++){
                    if(k>=i && k<=j) continue;
                    increasing &= prev < nums[k];
                    prev = nums[k];
                }
                if(increasing) res++;
            }
        }
        return res;
    }
}
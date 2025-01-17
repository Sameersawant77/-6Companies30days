class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while(left<right){
            int mid = left + (right-left)/2;
            int operations = 0;
            for(int num : nums){
                operations += (num-1)/mid;
            }
            if(operations<=maxOperations) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
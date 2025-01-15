class Solution {
    public int minimizeXor(int num1, int num2) {
        int difference = Integer.bitCount(num2) - Integer.bitCount(num1);
        int curr = 1, result = num1;
        while(difference!=0){
            if(difference<0 && (result&curr)!=0){
                result ^= curr;
                difference++;
            }
            if(difference>0 && (result&curr)==0){
                result |= curr;
                difference--;
            }
            curr <<= 1;
        }
        return result;
    }
}
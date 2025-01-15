class Solution {
    public int minimizeXor(int num1, int num2) {
        int targetBits = 0;
        while(num2>0){
            targetBits += num2&1;
            num2>>=1;
        }
        int setBits = 0;
        int temp = num1;
        while(temp>0){
            setBits += temp&1;
            temp>>=1;
        }
        if(setBits==targetBits) return num1;
        if(setBits<targetBits){
            int result = num1, remaining = targetBits-setBits;
            for(int i=0;i<32 && remaining > 0;i++){
                if((result & (1<<i)) == 0){
                    result |= (1<<i);
                    remaining--;
                }
            }
            return result;
        }
        else{
            int result = 0;
            for(int i=31;i>=0&&targetBits>0;i--){
                if((num1 & (1<<i)) != 0){
                    result |= (1<<i);
                    targetBits--;
                }
            }
            return result;
        }
    }
}
class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        int minus = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            charCount.put(c,charCount.getOrDefault(c,0)+1);
        }
        for(int value:charCount.values()){
            if(value>=3){
                while(value>=3){
                    minus += 2;
                    value -= 2;
                }
            }
        }
        return s.length() - minus;
    }
}
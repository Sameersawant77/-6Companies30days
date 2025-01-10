class Solution {
    public int firstUniqChar(String s) {
        int[] charHash = new int[26];
        for(int i=0;i<s.length();i++){
            charHash[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(charHash[s.charAt(i)-'a']<2) return i;
        }
        return -1;
    }
}
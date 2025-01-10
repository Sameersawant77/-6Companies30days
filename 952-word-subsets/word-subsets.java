class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] charHash = new int[26];
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<words2.length;i++){
            String word = words2[i];
            int[] currHash = hashBuilder(word);
            for(int j=0;j<26;j++){
                charHash[j] = Math.max(charHash[j],currHash[j]);
            }
        }
        for(int i=0;i<words1.length;i++){
            String word = words1[i];
            int[] word1Hash = hashBuilder(word);
            boolean isUniversal = true;
            for(int j=0;j<26;j++){
                if(word1Hash[j]<charHash[j]){
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal) result.add(word);
        }
        return result;
    }
    public int[] hashBuilder(String str){
        int[] hash = new int[26];
        for(int i=0;i<str.length();i++){
            hash[str.charAt(i)-'a']++;
        }
        return hash;
    }
}
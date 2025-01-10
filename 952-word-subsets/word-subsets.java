class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] charHash = new int[26];
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<words2.length;i++){
            String word = words2[i];
            int[] currHash = new int[26];
            for(int j=0;j<word.length();j++){
                int index = word.charAt(j)-'a';
                currHash[index]++;
                charHash[index] = Math.max(charHash[index],currHash[index]);
            }
        }
        for(int i=0;i<words1.length;i++){
            String word = words1[i];
            int[] compareHash = charHash.clone();
            for(int j=0;j<word.length();j++){
                compareHash[word.charAt(j)-'a']--;
            }
            for(int k=0;k<26;k++){
                if(compareHash[k]>0) break;
                if(k==25) result.add(word);
            }
        }
        return result;
    }
}
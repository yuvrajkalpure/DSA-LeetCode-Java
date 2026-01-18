class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int freq1[]=new int[26];
        int freq2[]=new int[26];
        int windowSize=s1.length();
        
        for(char c:s1.toCharArray()){
            freq1[c-'a']++;
        }
        
        for(int right=0;right<s2.length();right++){  
            //add right char
            freq2[s2.charAt(right)-'a']++;

            //remove left char if window too big
            if(right>=windowSize){
                freq2[s2.charAt(right-windowSize)-'a']--;
            }

            //compare when window size matches
            if(right>=windowSize-1){
                if(Arrays.equals(freq1,freq2)){
                    return true;
                }
            }
        }
        return false;
    }
}
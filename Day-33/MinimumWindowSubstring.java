class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        
        int minLen=Integer.MAX_VALUE;
        int start=0;
        int left=0;
        int right=0;
        int formed=0;
        int size=s.length();
        int required=t.length();

        int need[]=new int[256];
        
        for(char c : t.toCharArray()){
            need[c]++;
        }

        while(right<size){
            char c=s.charAt(right);

            if(need[c]>0){
                formed++;
            }
            need[c]--;

            while(formed==required){

                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }

                char l=s.charAt(left);
                need[l]++;
                if(need[l]>0){
                    formed--;
                }
                    
                left++;
            }

            right++;
        }
        return minLen==Integer.MAX_VALUE?"": s.substring(start,start+minLen);
    }
}
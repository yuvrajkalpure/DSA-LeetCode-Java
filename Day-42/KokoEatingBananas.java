class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;

        for(int p:piles){
            right=Math.max(right,p);
        }

        int res=right;
        while(left<=right){

            int mid=left+(right-left)/2;

            long hours=0;
            for(int p:piles){
                hours+=(p+mid-1)/mid; //ceil division 
            }

            if(hours<=h){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
}
class CapacityToShipPackagesWithInDDays {
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0;
        for(int w:weights){
            left=Math.max(left,w);
            right+=w;
        }

        while(left<right){
            int mid=left+(right-left)/2;

            int currentLoad=0;
            int daysUsed=1;

            for(int w:weights){
                if(w+currentLoad>mid){
                    daysUsed++;
                    currentLoad=0;
                }
                currentLoad+=w;
            }
            if(daysUsed>days){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }     
}
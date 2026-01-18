class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max=0;
        int currentArea=0;
        int l=0,r=height.length-1;
        while(l<r){
            if(height[l]<=height[r]){
                currentArea=height[l]*(r-l);
                l++;
            }else{
                currentArea=height[r]*(r-l);
                r--;
            }
            if(max<currentArea){
                max=currentArea;
            }
        }
        return max;
    }
}
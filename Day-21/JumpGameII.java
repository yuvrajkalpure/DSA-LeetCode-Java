class JumpGameII {
    public int jump(int[] nums) {
        int jumps=0;
        int currentEnd=0;
        int farthest=0; //one more jump

        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,i+nums[i]);

            if(i==currentEnd){
                jumps++;
                currentEnd=farthest;
            }
        }
        return jumps;
    }
}
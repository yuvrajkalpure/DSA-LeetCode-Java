class SingleNumber {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res ^= nums[i]; // XOR-commutative (1^1)^(2^2)^4=0^0^4=4  0^0=0,0^1=1
        }
        return res;
    }
}
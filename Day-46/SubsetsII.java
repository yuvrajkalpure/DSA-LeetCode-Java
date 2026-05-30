class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int[] nums,int index,List<Integer> path,List<List<Integer>> res){
     
        res.add(new ArrayList<>(path));

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
            continue; 
            }
            path.add(nums[i]);
            backtrack(nums,i+1,path,res);
            path.remove(path.size()-1);
        }
    }
}
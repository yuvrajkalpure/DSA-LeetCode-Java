class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int[] candidates,int target,int start,List<Integer> path,List<List<Integer>> res){
     
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        if(target<0){
            return;
        }

        for(int i=start;i<candidates.length;i++){
            path.add(candidates[i]);

            //recurse for permutation (order matters)
            //backtrack(candidates,target-candidates[i],start,path,res);
            backtrack(candidates,target-candidates[i],i,path,res);

            //backtrack
            path.remove(path.size()-1);
        }
    }
}
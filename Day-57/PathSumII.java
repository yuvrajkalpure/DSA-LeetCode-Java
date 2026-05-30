/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        pathSum(root,targetSum,new ArrayList<>(),res);
        return res;
    }
    private void pathSum(TreeNode root,int targetSum,List<Integer> path,List<List<Integer>> res) {
        if(root==null) return; 

        path.add(root.val);
        
        if(root.left==null && root.right==null && targetSum==root.val){
            res.add(new ArrayList<>(path));
        }else{
        
        int remaining = targetSum-root.val;
        pathSum(root.left,remaining,path,res);
        pathSum(root.right,remaining,path,res);
        }
        
        path.remove(path.size()-1);
    }
}
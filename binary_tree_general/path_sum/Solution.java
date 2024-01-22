class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
             return false;
        }
        
        return hitsTarget(root, targetSum, 0);
    }

    private boolean hitsTarget(TreeNode root, int targetSum, int sum){
        if (root.left == null && root.right ==null){
            return sum == targetSum - root.val;
        }

        if (root.left!=null && root.right != null){
            return (hitsTarget(root.left, targetSum, sum+root.val)
            || hitsTarget(root.right, targetSum, sum+root.val));
        } else if (root.left != null){
            return hitsTarget(root.left, targetSum, sum+root.val);
        } else  return hitsTarget(root.right, targetSum, sum+root.val);
    }
}

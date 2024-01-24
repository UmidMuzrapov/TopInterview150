/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return solve(0, nums.length - 1, nums);
  }

  private TreeNode solve(int start, int end, int[] nums) {
    if (start > end) return null;
    int mid = (int) Math.ceil((start + end) / 2.0);
    TreeNode root = new TreeNode(nums[mid]);
    if (start <= mid - 1) {
      root.left = solve(start, mid - 1, nums);
    }
    if (mid + 1 <= end) {
      root.right = solve(mid + 1, end, nums);
    }
    return root;
  }
}

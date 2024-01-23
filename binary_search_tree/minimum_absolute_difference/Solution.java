/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public int getMinimumDifference(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int min = Integer.MAX_VALUE;
    recurse(root, list);

    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) - list.get(i - 1) < min) {
        min = list.get(i) - list.get(i - 1);
      }
    }

    return min;
  }

  private void recurse(TreeNode root, ArrayList<Integer> list) {
    if (root == null) return;
    recurse(root.left, list);
    list.add(root.val);
    recurse(root.right, list);
  }
}

class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    calculateAverages(root, 0, result, count);
    for (int i = 0; i < result.size(); i++) {
      result.set(i, result.get(i) / count.get(i));
    }
    return result;
  }

  private void calculateAverages(
      TreeNode root, int level, List<Double> result, List<Integer> count) {
    if (root == null) return;

    if (level == result.size()) {
      result.add((double) root.val);
      count.add(1);
    } else {
      result.set(level, result.get(level) + root.val);
      count.set(level, count.get(level) + 1);
    }

    calculateAverages(root.left, level + 1, result, count);
    calculateAverages(root.right, level + 1, result, count);
  }
}

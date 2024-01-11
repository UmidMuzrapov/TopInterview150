class Solution {
  public int removeDuplicates(int[] nums) {
    int prev = nums[0];
    HashSet<Integer> indices = new HashSet<Integer>();

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == prev) {
        indices.add(i);
      }

      prev = nums[i];
    }

    int curI = 0;
    for (int i = 0; i < nums.length; i++) {
      if (!indices.contains(i)) {
        nums[curI] = nums[i];
        curI++;
      }
    }

    return nums.length - indices.size();
  }
}

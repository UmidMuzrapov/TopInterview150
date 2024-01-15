/**
 * map that maps number to its index for num in nums if map contains number if j - i <= k return
 * true put num, j
 */
class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int j = 0; j < nums.length; j++) {
      if (map.containsKey(nums[j])) {
        if (j - map.get(nums[j]) <= k) {
          return true;
        }
      }

      map.put(nums[j], j);
    }

    return false;
  }
}

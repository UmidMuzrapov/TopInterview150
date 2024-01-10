class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;

        for (int i=0; i<nums.length; i++){
            if (nums[i]==val){
                int li = lastIndexOf(nums, val, i);
                if (li != -1){
                    int temp = nums[i];
                    nums[i] = nums[li];
                    nums[li] = temp;
                }
            } 
        }

        for (int num: nums){
            if (num==val) count++;
        }

        return nums.length - count;
    }

    private int lastIndexOf(int[] nums, int val, int k){
        for (int i = nums.length-1; i>k; i--){
            if (nums[i]!= val){
                return i;
            }
        }

        return -1;
    }
}

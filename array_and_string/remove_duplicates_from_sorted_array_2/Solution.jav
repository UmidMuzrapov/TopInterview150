class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int prev = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i < nums.length; i++){
            if (nums[i] == prev){
                count++;
                if (count>2) nums[i] = Integer.MAX_VALUE;
                else sum++;
            } else{
                count = 1;
                sum++;
                prev= nums[i];
            }
        }


        Arrays.sort(nums);
        return sum;
    }
}

/**
result
for num in nums
    if num - prev > 1
        add int[] from start to index -1 of num
        start = index of num 
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length ==0 ){
            return new LinkedList<String>();
        }

        List<String> result =  new LinkedList<String>();
        int start = 0;

        for (int i=1; i<nums.length; i++){
            if ((Math.abs(nums[i] - nums[i-1])> 1)){
                String str;
                if (start!=i-1){
                    str = String.format("%d->%d", nums[start], nums[i-1]);
                } else{
                    str = String.valueOf(nums[start]);
                } 

                result.add(str);
                start = i;
            } 
        }

        if (start == nums.length - 1){
            result.add(String.valueOf(nums[start]));
        } else{
            result.add(String.format("%d->%d", nums[start], nums[nums.length-1]));
        }

        return result;
    }
}

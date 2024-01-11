/**
input: nums 
output: majorityElement

algorithm considerations
Sorting -> n logn
map -> n, n

for num in nums
    if num in map 
        increase its freq
        if freq>curMax curMax = freq
    else
        add
        if freq>curMax curMax = freq

 */

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxFreq = Integer.MIN_VALUE;
        int elem = 0;

        for (int num: nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }

            if (maxFreq < map.get(num)){
                maxFreq = map.get(num);
                elem = num;
            }
        }

        return elem;
    }
}

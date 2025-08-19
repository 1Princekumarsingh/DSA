package Arrays;

import java.util.HashMap;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int cal = target-nums[i];
            if(helper.containsKey(cal)){
                return new int[] {helper.get(cal), i};
            }
            helper.put(nums[i], i);
        }
        return new int[] {};
    }
}

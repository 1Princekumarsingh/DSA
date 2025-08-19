package Arrays;

public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currBest=nums[0], overallBest=nums[0];

        for(int i=1; i<n; i++){
            if(currBest>=0){
                currBest += nums[i];
            }
            else{
                currBest=nums[i];
            }
            overallBest = Math.max(currBest, overallBest);
        }
        return overallBest;
    }
}

package Arrays;

public class Check_if_Array_Is_Sorted_and_Rotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int prev = nums[0], count = 0;
        for(int i=1; i<n; i++){
            if(nums[i]<prev){
                if(nums[n-1] <= nums[0]){
                    count++;
                }else return false;
            }
            prev = nums[i];
        }
        return count  < 2;
    }
}

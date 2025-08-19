package Arrays;

public class RotateArray {
    static void reverse(int[] nums, int st, int end){
        int temp;
        while(st<end){
            temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n; //Edge case for k >= nums.length
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
}

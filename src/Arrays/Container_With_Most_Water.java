package Arrays;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int n = height.length;
        int left=0, right = n-1;
        int ans = 0;
        while(left<right){
            int st = height[left];
            int end = height[right];

            int area = (Math.min(st,end))*(right-left);
            ans = Math.max(ans,area);

            if(st<end) left++;
            else right--;
        }
        return ans;
    }
}

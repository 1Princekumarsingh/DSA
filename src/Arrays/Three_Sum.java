package Arrays;

import java.util.*;

public class Three_Sum {
    static long getHash(int x, int y, int z){
        long hash = x;
        hash = hash * 100000 + y;
        hash = hash * 100000 + z;
        return hash;
    }
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        HashSet<Long> duplicateCheck = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        int tar =0;
        for(int i=0; i<n; i++){
            int ntar = -nums[i];
            int st=i+1, end=n-1;
            while(st<end){
                if(nums[st]+nums[end] > ntar) end--;
                else if(nums[st]+nums[end]< ntar) st++;
                else{
                    long hash = getHash(nums[i],nums[st],nums[end]);
                    if(duplicateCheck.contains(hash)==false){
                        duplicateCheck.add(hash);
                        ans.add(Arrays.asList(nums[i],nums[st], nums[end]));
                    }
                    st++;
                    end--;
                }
            }
        }
        return ans;
    }
}

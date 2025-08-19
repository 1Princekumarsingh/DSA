package Arrays;

public class Maximum_Sum_Circular_Subarray {
    static int kadane(int[] arr){
        int currBest=arr[0], overallBest=arr[0];
        for(int i=1; i<arr.length; i++){
            if(currBest>=0){
                currBest+=arr[i];
            }
            else{
                currBest=arr[i];
            }
            overallBest = Math.max(overallBest,currBest);
        }
        return overallBest;
    }
    public int maxSubarraySumCircular(int[] arr) {

        int n = arr.length;
        int total =0;
        int[] temp = new int[n];

        for(int i=0; i<n; i++){
            temp[i] = (-1)*arr[i];
            total+=arr[i];
        }
        int maxKadane = kadane(arr); // non-wrapped max
        int minKadane = kadane(temp); // min subarray in original
        int circularMax = total + minKadane; ;

        if(maxKadane<0){
            return maxKadane;
        }
        return Math.max(maxKadane, circularMax);
    }
}

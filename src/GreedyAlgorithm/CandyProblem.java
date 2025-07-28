package GreedyAlgorithm;

import java.util.Arrays;

public class CandyProblem {
    public int candy(int[] arr) {
        int n = arr.length;
        int prev = 1;
        int[] helper = new int[n];
        Arrays.fill(helper, 1); // fill all elements

        //from left to right we are not comparing arr[i] with arr[i+1]
        for(int i=1; i<n; i++){ //left to right
            if(arr[i]>arr[i-1]){
                helper[i] = helper[i-1]+1 ;
            }
        }
        for(int i=n-2; i>=0; i--){ //right to left
            if(arr[i]>arr[i+1]){
                helper[i] = Math.max(helper[i], helper[i + 1] + 1);
            }
        }
        int total = 0;
        for (int i : helper){
            total += i;
        }
        return total;
    }
}

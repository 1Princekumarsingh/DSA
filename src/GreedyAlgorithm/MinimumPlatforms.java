package GreedyAlgorithm;
import java.util.*;
public class MinimumPlatforms {

        // Function to find the minimum number of platforms required at the railway station
        static int findPlatform(int arr[], int dep[]) {
            Arrays.sort(arr);
            Arrays.sort(dep);

            int n = arr.length;
            int platformNeeded = 1, maxPlatform = 1;
            int i = 1, j = 0;//first train arrived
            while(i<n && j<n){
                if(arr[i]<=dep[j]){
                    platformNeeded++;
                    i++;
                }
                else{
                    platformNeeded--;
                    j++;
                }
                maxPlatform = Math.max(maxPlatform, platformNeeded) ;
            }
            return maxPlatform;
        }
    }

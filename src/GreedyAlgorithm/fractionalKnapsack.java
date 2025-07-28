package GreedyAlgorithm;
import java.util.*;
public class fractionalKnapsack {
        double fractionalKnapsack(int[] values, int[] weights, int W) {
            int n  = values.length;

            Integer[] idx = new Integer[n];
            for(int i=0; i<n; i++){
                idx[i] = i;
            }
            double[] ratio = new double[n];
            for(int i=0; i<n; i++){
                ratio[i] = (double) values[i]/weights[i];
            }
            Arrays.sort(idx,(a,b)->Double.compare(ratio[b],ratio[a]));

            double totalValues = 0.0;

            for(int i=0;i<n;i++){
                int x = idx[i];
                if(W>=weights[x]){
                    totalValues+=values[x];
                    W -= weights[x];
                }else {
                    totalValues += values[x] * ((double) W / weights[x]);
                    break;
                }
            }
            return totalValues;
        }
    }


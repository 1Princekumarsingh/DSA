package GreedyAlgorithm;
import java.util.*;
public class JobSequencingProblem {

        public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
            int n = deadline.length;
            Integer[] idx = new Integer[n];

            for (int i = 0; i < n; i++) {
                idx[i] = i;
            }
            Arrays.sort(idx, (a, b) -> profit[b] - profit[a]);

            int maxDeadline = 0;
            for (int d : deadline) {
                maxDeadline = Math.max(maxDeadline, d);
            }

            boolean[] slot = new boolean[maxDeadline + 1];

            int count = 0, totalProfit = 0;

            for (int i = 0; i < n; i++) {
                int jobIdx = idx[i];
                for (int t = deadline[jobIdx]; t > 0; t--) {
                    if (!slot[t]) {
                        slot[t] = true;
                        count++;
                        totalProfit += profit[jobIdx];
                        break;
                    }
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(count);
            ans.add(totalProfit);
            return ans;
        }
    }


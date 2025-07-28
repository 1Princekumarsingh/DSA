package GreedyAlgorithm;
import java.util.*;
public class N_meetings_in_one_room_gfg {

    public int maxMeetings(int start[], int end[]) {
        int n = start.length;

        ArrayList<Integer> idx  = new ArrayList<>();
        for(int i=0; i<n; i++){
            idx.add(i);
        }
        Collections.sort(idx,(a,b)->Integer.compare(end[a],end[b]));

        int totalMeetings = 1;
        int lastEndTime = end[idx.get(0)];

        for(int i=1; i<n; i++){
            int x = idx.get(i);
            if(start[x]>lastEndTime){
                totalMeetings++;
                lastEndTime = end[x];
            }
        }
        return totalMeetings;
    }
}


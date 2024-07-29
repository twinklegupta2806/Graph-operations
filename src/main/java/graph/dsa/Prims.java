package graph.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Prims
{
    ArrayList<Integer> getMinimumSpanningCost(ArrayList<HashMap<Integer, Integer>> adj){
        ArrayList<Integer> weights = new ArrayList<>();
        boolean[] inMST = new boolean[adj.size()];

        for(int i=0;i<adj.size();i++){
            weights.add(Integer.MAX_VALUE);
        }
        weights.set(0, 0);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.offer(Map.entry(0,0));
        while(!pq.isEmpty()){
            // element which is once present in queue, has been polled, is kind of fix, its distance
            Integer current = pq.poll().getKey();
            inMST[current] = true;
            for(Map.Entry<Integer, Integer> connectedEdge: adj.get(current).entrySet()) {
                if(!inMST[connectedEdge.getKey()] && weights.get(connectedEdge.getKey())>connectedEdge.getValue()){
                    pq.offer(Map.entry(connectedEdge.getKey(), connectedEdge.getValue()));
                    weights.set(connectedEdge.getKey(), connectedEdge.getValue());
                }
            }
        }

        return weights;
    }
}

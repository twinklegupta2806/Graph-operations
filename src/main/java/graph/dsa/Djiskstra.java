package graph.dsa;
import java.util.*;

public class Djiskstra
{
    ArrayList<Integer> shortestPathByDjisktra(ArrayList<HashMap<Integer, Integer>> adj){
        ArrayList<Integer> distance = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            distance.add(Integer.MAX_VALUE);
        }
        distance.set(0, 0);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.offer(Map.entry(0,0));
        while(!pq.isEmpty()){
            // element which is once present in queue, has been polled, is kind of fix, its distance
            Integer current = pq.poll().getKey();
            for(Map.Entry<Integer, Integer> connectedEdge: adj.get(current).entrySet()) {
                if(distance.get(connectedEdge.getKey())==Integer.MAX_VALUE)
                    pq.offer(Map.entry(connectedEdge.getKey(), connectedEdge.getValue()));
                if(distance.get(connectedEdge.getKey())>distance.get(current)+connectedEdge.getValue())
                    distance.set(connectedEdge.getKey(), distance.get(current)+connectedEdge.getValue());
            }
        }

        System.out.println("\nlets get to complexity, firstly the time complexity, it is O((V+E)logV)  ");

        return distance;
    }
}

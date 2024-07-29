package graph.dsa;

import java.util.*;

public class BellmanFord
{
    ArrayList<Integer> shortestPath(ArrayList<HashMap<Integer, Integer>> adjList){
        ArrayList<Integer> distance = new ArrayList<>(adjList.size());
        for(int i=0;i<adjList.size();i++){
            distance.add(Integer.MAX_VALUE);
        }
        Queue<Integer> nodes = new LinkedList<>();
        distance.set(0,0);
        nodes.add(0);
        while(!nodes.isEmpty()){
            int current = nodes.poll();
            for(Map.Entry<Integer, Integer> connected: adjList.get(current).entrySet()){
                if(distance.get(connected.getKey())>distance.get(current)+connected.getValue()){
                    nodes.offer(connected.getKey());
                    distance.set(connected.getKey(), distance.get(current)+connected.getValue());
                }
            }
        }

        System.out.println("the time complexity is increased with belmanm ford, ie, O(E*V)");
        return distance;
    }
}

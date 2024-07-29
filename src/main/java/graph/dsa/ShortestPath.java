package graph.dsa;

import java.util.*;

public class ShortestPath
{
    public ArrayList<Integer> shortestPath(ArrayList<ArrayList<Integer>> adj){
        System.out.println("\nLet the source be 0");
        System.out.println("Now we will create a distance array which will record distance from 0 to that node");

        ArrayList<Integer> distance = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            distance.add(Integer.MAX_VALUE);
        }
        int source =0;
        distance.set(source, 0);
        System.out.println("lets see distance array "+ distance );
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        while(!q.isEmpty()){
            int current = q.poll();
            for(Integer edges: adj.get(current)){
                if(distance.get(edges)==Integer.MAX_VALUE){
                    distance.set(edges, distance.get(current)+1);
                    q.offer(edges);
                }
            }
        }
        return distance;
    }
}

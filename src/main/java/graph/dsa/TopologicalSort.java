package graph.dsa;

import java.util.ArrayList;
import java.util.*;

public class TopologicalSort
{
    void printInTopologicalOrder(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> indegree = new ArrayList<>();
        for(int i=0;i<adj.size();i++) {
            indegree.add(0);
        }

        for(int i=0;i<adj.size();i++){
            for(Integer current: adj.get(i)) {
                indegree.set(current, indegree.get(current)+1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> sortedOrder = new PriorityQueue<>(Map.Entry.comparingByValue());
        for(int i=0;i<indegree.size();i++) {
            if(indegree.get(i)==0)
                sortedOrder.offer(Map.entry(i, indegree.get(i)));
        }

        System.out.println("\nthis is how indegree storage looks like" + indegree);

        while(!sortedOrder.isEmpty()) {
            System.out.println("This is how priority queue looks like "+ sortedOrder);

            Map.Entry<Integer, Integer> current = sortedOrder.poll();
            assert current != null;
            System.out.println("\nIndependent element = "+ current.getKey());
            for(int i=0;i<adj.get(current.getKey()).size();i++) {
                Integer edge = adj.get(current.getKey()).get(i);
                indegree.set(edge, indegree.get(edge)-1);
                if(indegree.get(edge)==0)
                    sortedOrder.offer(Map.entry(edge, indegree.get(edge)));
            }
        }
    }
}

package graph.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    public void BFSUndirectedGraph(ArrayList<ArrayList<Integer>> adj){
        System.out.println("\nBredth first search traverses the graph level by level, covering nodes at shorter distance first than others");

        Queue<Integer> nodesToTraverse = new LinkedList<>();
        ArrayList<Integer> vis = new ArrayList<>(adj.size());

        for(int i=0;i<adj.size();i++){
            vis.add(0);
        }

        if(adj.size()==0) return;
        for(int i=0;i<adj.size();i++){
            // this inner code will only run for non visited nodes in worst casse O(V)
            if(vis.get(i)==0){
                nodesToTraverse.offer(i);
                vis.set(i, 1);
                // this would run worst of O(V) ie when all edges are connected to 1 node
                while(!nodesToTraverse.isEmpty()){
                    int current = nodesToTraverse.poll();
                    System.out.println("ELement = " + current);
                    // once for each edge but due to if block this will only executed if edge is not visited
                    for(Integer connectedElements: adj.get(current)){
                        if(vis.get(connectedElements)==0){
                            nodesToTraverse.offer(connectedElements);
                            vis.set(connectedElements, 1);
                        }
                    }
                }
            }
        }

        System.out.println("lets find out the complexity now ^^");
        System.out.println("Both the space and time complexity of this algorithm is O (V + E)");

    }
}

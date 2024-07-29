package graph.dsa;

import java.util.ArrayList;

public class DFS
{
    public void DFSUndirectedGraph(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> vis = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            vis.add(0);
        }
        for(int i=0;i<adj.size();i++){
            if(vis.get(i)==0){
                dfsRecursion(i, adj, vis);
            }
        }

        System.out.println("We have done DFS of Graph, its time and space complexity will be O(V + E)");
    }

    public void dfsRecursion(int source, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> vis){
        System.out.println("DFS element = "+ source);
        vis.set(source, 1);
        for(Integer connections: adj.get(source)){
            if(vis.get(connections)==0){
                dfsRecursion(connections, adj, vis);
            }
        }
    }
}

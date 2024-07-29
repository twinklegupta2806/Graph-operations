package graph.dsa;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        int v=6;
        System.out.println("Nodes we already know will be assumed to start from 0 to "+ (v-1));
        System.out.println("Let's create an undirected graph");
        UndirectedGraph ug = new UndirectedGraph(v);
        ug.addEdge(0,1);
        ug.addEdge(0,5);
        ug.addEdge(1,3);
        ug.addEdge(2,3);
        ug.addEdge(3,5);
        ug.addEdge(2,4);
        ug.addEdge(3,4);

        ug.display();

        BFS bfs = new BFS();
        bfs.BFSUndirectedGraph(ug.adjList);

        DFS dfs = new DFS();
        dfs.DFSUndirectedGraph(ug.adjList);

        ShortestPath sp = new ShortestPath();
        System.out.println("Here is the shortest path store = "+sp.shortestPath(ug.adjList));

        DirectedGraph dg = new DirectedGraph(v+2);
        dg.addEdge(0,3);
        dg.addEdge(0,4);
        dg.addEdge(1,3);
        dg.addEdge(2,4);
        dg.addEdge(3,5);
        dg.addEdge(3,6);
        dg.addEdge(3,7);
        dg.addEdge(2,7);
        dg.addEdge(4, 6);

        dg.display();

        TopologicalSort tg = new TopologicalSort();
        tg.printInTopologicalOrder(dg.adjList);

        WeightedDirectedGraph wdg = new WeightedDirectedGraph(5);
        wdg.addEdgeWithWeight(0,1,4);
        wdg.addEdgeWithWeight(0,2,1);
        wdg.addEdgeWithWeight(2,3,4);
        wdg.addEdgeWithWeight(2,1,2);
        wdg.addEdgeWithWeight(3, 4, 4);
        wdg.addEdgeWithWeight(1, 4, 4);

        wdg.display();

        Djiskstra djiskstra = new Djiskstra();
        System.out.println("\nthe distance with djisktra = "+ djiskstra.shortestPathByDjisktra(wdg.adj));

        WeightedDirectedGraph wdgNeg = new WeightedDirectedGraph(4);
        wdgNeg.addEdgeWithWeight(0,1, 2);
        wdgNeg.addEdgeWithWeight(0,2,3);
        wdgNeg.addEdgeWithWeight(2,1,-2);
        wdgNeg.addEdgeWithWeight(1,3, 1);

        // ideally it should be 0 1 3 2 but we will get 0 1 3 3

        System.out.println("\nthe distance with djisktra with negative edges  = "+ djiskstra.shortestPathByDjisktra(wdgNeg.adj));

        BellmanFord bf = new BellmanFord();

        System.out.println("\n the distance with belman ford = "+ bf.shortestPath(wdgNeg.adj));

        WeightedDirectedGraph wdgPrims = new WeightedDirectedGraph(4);
        wdgPrims.addEdgeWithWeight(0, 2, 3);
        wdgPrims.addEdgeWithWeight(0, 1, 5);
        wdgPrims.addEdgeWithWeight(2, 3, 1);
        wdgPrims.addEdgeWithWeight(3, 0, 1);
        wdgPrims.addEdgeWithWeight(2, 1, 2);

        Prims pm = new Prims();

        // below should give 0 2 3 1 with starting point 0, its based on starting point,
        System.out.println("\n prims minimum cost is sum of all these weights = "+ pm.getMinimumSpanningCost(wdgPrims.adj));
    }
}
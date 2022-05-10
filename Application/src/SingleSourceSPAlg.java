
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author عائشة
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    int INF = super.INF;//
    int nV = super.verticesNo;//noVertices
    char[] letters = super.letters;

    public SingleSourceSPAlg(int verticesNo,Graph graph) {
        super(verticesNo,graph);
    }

  
   


    int getMinimumVertex(boolean[] mst, int[] key, int noV) {
        int minKey = Integer.MAX_VALUE;
        int ver = -1;
        for (int i = 0; i < noV; i++) {
            if (mst[i] == false && minKey > key[i]) {
                minKey = key[i];
                ver = i;
            }
        }
        return ver;
    }

    public void computeDijkstraAlg(int sourceVertex, int noV,  String r) {//Edge matrix[][],

        boolean[] spt = new boolean[noV];
        int[] distance = new int[noV];

        //Initialize all the distance to infinity
        for (int i = 0; i < noV; i++) {
            distance[i] = INF;
        }

        //start from the vertex 0
        distance[sourceVertex] = 0;

        //create SPT
        for (int i = 0; i < noV; i++) {

            //get the vertex with the minimum distance
            int vertex_U = getMinimumVertex(spt, distance, noV);

            //include this vertex in SPT
            spt[vertex_U] = true;

            //iterate through all the adjacent vertices of above vertex and update the keys
            for (int vertex_V = 0; vertex_V < noV; vertex_V++) {
                //check of the edge between vertex_U and vertex_V
                if (graph.adjMatrix[vertex_U][vertex_V].getWeight() > 0) {
                    //check if this vertex 'vertex_V' already in spt and
                    // if distance[vertex_V]!=Infinity

                    if (spt[vertex_V] == false && graph.adjMatrix[vertex_U][vertex_V].getWeight() != INF) {
                        //check if distance needs an update or not
                        //means check total weight from source to vertex_V is less than
                        //the current distance value, if yes then update the distance

                        int newKey = graph.adjMatrix[vertex_U][vertex_V].getWeight() + distance[vertex_U];
                        if (newKey < distance[vertex_V]) {
                            distance[vertex_V] = newKey;
                        }
                    }
                }
            }
        }
        //print shortest path tree
        printDijkstra(sourceVertex, distance, noV, r);
    }

    ///make one for numbers and one for letters
    public void printDijkstra(int sourceVertex, int[] graph, int noV, String r) {
        if (r.equalsIgnoreCase("r1")) {
            System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");

            for (int i = 0; i < noV; i++) {
                if (graph[i] == 9999999) {
                    System.out.println("There is no direct path from source vertex: " + letters[sourceVertex] + " to vertex: " + letters[i]
                    );
                } else {
                    System.out.println("Source Vertex: " + letters[sourceVertex] + " to vertex " + letters[i]
                            + " distance: " + graph[i]);
                }
            }
        }

    }
}

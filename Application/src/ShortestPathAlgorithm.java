/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author عائشة
 */
public class ShortestPathAlgorithm {
    char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};//for printing
    int INF = 9999999;
    int verticesNo; //get from the graph
    Graph graph;

    //get and set for the vertices No
    ShortestPathAlgorithm(int verticesNo,Graph graph) {
        this.graph=graph;
        this.verticesNo=verticesNo;
    }
}

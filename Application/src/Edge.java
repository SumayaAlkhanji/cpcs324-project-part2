/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ط¹ط§ط¦ط´ط©
 */
import java.util.*;

public class Edge {

    private int weight;

    private Vertex source;
    private Vertex target;

    public Edge(Vertex source, Vertex target, int w) {
        // this.parent = parent;

        this.source = source;
        this.target = target;
        this.weight = w;

    }

//    public Edge(Vertex dest) {
//        this.destVertex = dest;
//        this.weight = 1;//need to check
//    }
    public int getWeight() {
        return weight;
    }

    public Vertex getSourceVertex() {
        return source;
    }

    public Vertex getTargetVertex() {
        return target;
    }
//    public Vertex getDestVertex() {
//        return destVertex;
//    }
}

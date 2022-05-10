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

public class Vertex {

    private boolean isVisited;
    private char label;
    private int weight;
    private int position;
    //need to chbeck
    int vCount = 0;

    public Vertex(char label, int position) {
        this.label = label;
        this.isVisited = true;
        this.weight = 0;
        this.position = position;
        vCount++;
    }

    public char getLabel() {
        return label;
    }


    public int getVertPos() {
        return position;

    }

    public int getVerticesNo() {
        return vCount;
    }
}

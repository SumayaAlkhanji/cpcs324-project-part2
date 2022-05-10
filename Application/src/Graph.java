
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

class Graph {

    int index = 0;
    int veticesNo;
    private Vertex[] vertices;
    int INF = 9999999;
    Edge[][] adjMatrix;
    boolean isDigraph = false;
    int edgeNo;

    Graph(int veticesNo) {

        this.veticesNo = veticesNo;
        vertices = new Vertex[veticesNo];//vertices array
        adjMatrix = new Edge[veticesNo][veticesNo];

    }

    void readGraphFromFile() throws FileNotFoundException {
        //to read from file
        File myObj = new File("File.txt");
        Scanner myReader = new Scanner(myObj);
        int number = myReader.nextInt();
        if (number == 1) {
            isDigraph = true;
        }
        veticesNo = myReader.nextInt();
        edgeNo = myReader.nextInt();

        //Creat an ArrayList for the vertices
        ArrayList<String> array = new ArrayList<>();

        // Creating an ArrayList of String type for all the source vertices
        ArrayList<String> sources = new ArrayList<>();

        //Creat an ArrayList for all the destination vertices
        ArrayList<String> des = new ArrayList<>();

        //Creat an ArrayList for the  weight
        ArrayList<Integer> w = new ArrayList<>();

        //read from file   
        while (myReader.hasNextLine()) {
            //read the source
            String source = myReader.next();
            if (!array.contains(source)) { //check if it is not in the array
                array.add(source);//add to the vertices array
            }
            sources.add(source);//add to the sources array
            String edge = myReader.next();
            des.add(edge);//add to the destination array
            int weight = myReader.nextInt();//read the weight
            w.add(weight);//dd to the weight array

        }
        myReader.close();

        //add the vertices
        for (int j = 0; j < array.size(); j++) {
            char v = (array.get(j)).charAt(0);
            addVertex(v);
        }

        //add edges
        for (int j = 0; j < sources.size(); j++) {
            char source = sources.get(j).charAt(0);//convert into char
            char destination = des.get(j).charAt(0);//convert into char
            int weight = w.get(j);
            addEdge(source, destination, weight);
        }
    }

    void makeGraph(int n, int m) {
        veticesNo = n;
        edgeNo = m;
        Random r = new Random(); //instance of random class
        //to generate random values from 0-100 
        int upperbound = 100;

        //add the vertices
        for (int i = 0; i < n; i++) {

            addVertex((char) i);//add the vertices

        }
        //creat edges
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (j == n) {
                j = 0;
            }
            int w = r.nextInt(upperbound);
            int randomNumber = r.nextInt(10);
            addEdge((char) j, (char) randomNumber, w);
            j++;

        }
    }

    void addVertex(char v) {//add to the vertices
        if (addvertlabel(v) == true) {
            vertices[index] = new Vertex(v, index);
            index++;
        }
    }

    void addEdge(char source, char destination, int des) {//add the edges
        int sourceIndex = 0;
        Vertex vSource = null;
        Vertex target = null;
        int desIndex = 0;

        //method to find indexes
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getLabel() == source) {
                sourceIndex = vertices[i].getVertPos();
                vSource = vertices[i];
            }
            if (vertices[i].getLabel() == destination) {
                desIndex = vertices[i].getVertPos();
                target = vertices[i];
            }
        }
        //Each cell adjMatrix[i][j] is filled with the distance from the ith vertex to the jth vertex.
        adjMatrix[sourceIndex][desIndex] = new Edge(vSource, target, des);

    }

    //check if this new vertex is already existed in the array or not
    public boolean addvertlabel(char vlabel) {
        for (int i = 0; i < index; i++) {

            if (vlabel == vertices[i].getLabel()) {
                return false;
            }
        }
        return true;

    }

    //to print the initial graph, and modified the rest of the edges
    void initialGraph(String r) {

        if (r.equalsIgnoreCase("r1")) {
            Vertex sourceIndex = null;
            Vertex target = null;
            System.out.print("    ");

            for (int a = 0; a < vertices.length; a++) {
                System.out.printf(" %-1c ", vertices[a].getLabel());
            }
            System.out.println();
            int index = 0;
            for (int i = 0; i < veticesNo; i++) {
                System.out.print(vertices[index].getLabel());

                System.out.print("   ");

                for (int j = 0; j < veticesNo; j++) {
                    if (i == j) {//if the destination is the source,w =0;
                        adjMatrix[i][j] = new Edge(sourceIndex, target, 0);
                    }
                    if (adjMatrix[i][j] == null) {
                        sourceIndex = vertices[i];
                        target = vertices[j];
                        adjMatrix[i][j] = new Edge(sourceIndex, target, INF);//since there is no direct access assign 9999999 as INF
                        System.out.printf("%-2s", "∞");
                        System.out.print(" ");
                    } else {
                        System.out.printf("%-2d", adjMatrix[i][j].getWeight(), " ");
                        System.out.print(" ");

                    }
                }
                System.out.println();
                index++;

            }
            System.out.println("\n");

        }

        if (r.equalsIgnoreCase("r2")) {
            Vertex sourceIndex = null;
            Vertex target = null;
            for (int i = 0; i < veticesNo; i++) {
                for (int j = 0; j < veticesNo; j++) {
                    if (i == j) {//if the destination is the source,w =0;
                        adjMatrix[i][j] = new Edge(sourceIndex, target, 0);
                    }
                    if (adjMatrix[i][j] == null) {
                        sourceIndex = vertices[i];
                        target = vertices[j];
                        adjMatrix[i][j] = new Edge(sourceIndex, target, INF);//since there is no direct access assign 9999999 as INF
                    }
                }
            }
        }

    }

    void printResulte(String r, Graph g) { //to print the algorithms result and running time
        System.out.println("<<<<The Dijkstra's Shortest Path Algorithm>>>>\n");
        long startTime_1 = System.nanoTime();
        SingleSourceSPAlg a = new SingleSourceSPAlg(g.veticesNo, g);
        a.computeDijkstraAlg(0, g.veticesNo, r);//source=0   //adjMatrix, 
        long endTime_1 = System.nanoTime();
        long duration_1 = (endTime_1 - startTime_1) ;
        System.out.println("\nThe running time of the algorithms: Dijkstra’s= " + duration_1 + " nano second");

        System.out.println("\n<<<<The Floyded's Warshall algorithm>>>>");
        long startTime_2 = System.nanoTime();
        AllSourceSPAlg b = new AllSourceSPAlg(g.veticesNo, g);
        b.computeFloyedWarshalAlg(r);
        long endTime_2 = System.nanoTime();
        long duration_2 = (endTime_2 - startTime_2);
        System.out.println("\nThe running time of the algorithms: Floyd–Warshall= " + duration_2 + " nano second");
    }
}

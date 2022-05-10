
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ط¹ط§ط¦ط´ط©
 */
//IMPOERTANT: Need to  get the right in dex for the letters req
public class AppMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);//to get the input from the ueser
        //Start the program

        Requirement1();//display first requirement
        Requirement2(sc);//display first requirement

    }

    public static void Requirement1() throws FileNotFoundException {
        System.out.println("------------------------The first requirement------------------------\n");

        Graph our = new Graph(10);
        our.readGraphFromFile();
        our.initialGraph("r1");//print the matrix befor any change and to modified the rest of the edges

        our.printResulte("r1", our);//print the algorithms resulte

    }

    public static void Requirement2(Scanner sc) {
        System.out.println("------------------------The second requirement------------------------\n");

        //display the second requriment minue
        System.out.println("--------------------------------------\nNumber                       n,m");
        System.out.println("1:                      n=2000 m=10000\n2:                      n=4000 m=20000\n3:                      n=6000 m=30000\n4:                      n=8000 m=40000\n5:                      n=10000 m=50000");
        System.out.println("Enter 6 to quit");//ask the user to enter thier chose
        int a = 0;

        while (a != 6) {
            System.out.print("Enter your chose: ");//ask the user to enter thier chose

            a = sc.nextInt();
            //Switch expression 

            switch (a) {
                //Case statements

                case 1:
                    System.out.println("------------------------First case------------------------\n");
                    int n = 2000;
                    int m = 10000;
                    System.out.println("Size: n=" + n + " m= " + m);
                    make_graph(n, m);
                    break;
                case 2:
                    System.out.println("------------------------Second case------------------------\n");
                    n = 4000;
                    m = 20000;
                    System.out.println("Size: n=" + n + " m= " + m);
                    make_graph(n, m);
                    break;
                case 3:
                    System.out.println("------------------------Third case------------------------\n");
                    n = 6000;
                    m = 30000;
                    System.out.println("Size: n=" + n + " m= " + m);
                    make_graph(n, m);
                    break;
                case 4:
                    System.out.println("------------------------Fourth case------------------------\n");
                    n = 8000;
                    m = 40000;
                    System.out.println("Size: n=" + n + " m= " + m);
                    make_graph(n, m);
                    break;
                case 5:
                    System.out.println("------------------------Fifth case------------------------\n");
                    n = 10000;
                    m = 50000;
                    System.out.println("Size: n=" + n + " m= " + m);
                    Graph myGraph_5 = new Graph(n);//creat graph
                    myGraph_5.makeGraph(n, m);//call the method makeGraph
                    myGraph_5.initialGraph("r2"); //to modified the rest of the edges
                    myGraph_5.printResulte("r2", myGraph_5);//print the algorithms resulte(Running time)                   

            }
        }

    }

    public static void make_graph(int n, int m) {
        Graph myGraph = new Graph(n);//creat graph
        myGraph.makeGraph(n, m);//call the method makeGraph
        myGraph.initialGraph("r2"); //to modified the rest of the edges
        myGraph.printResulte("r2", myGraph);//print the algorithms resulte(Running time)
    }
}

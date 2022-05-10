/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author عائشة
 */
public class AllSourceSPAlg extends ShortestPathAlgorithm {

    int INF = super.INF;//
    int nV = super.verticesNo;//noVertices
    char[] letters = super.letters;

    public AllSourceSPAlg(int verticesNo, Graph graph) {
        super(verticesNo, graph);
    }

    void computeFloyedWarshalAlg(String r) {
        int matrix[][] = new int[nV][nV];
        int i, j, k;

        for (i = 0; i < nV; i++) {
            for (j = 0; j < nV; j++) {
                matrix[i][j] = graph.adjMatrix[i][j].getWeight();
            }
        }

        // Adding vertices individually
        for (k = 0; k < nV; k++) {
            for (i = 0; i < nV; i++) {
                for (j = 0; j < nV; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }

            }
            if (r.equalsIgnoreCase("r1")) {
                //  /print each iteration

                System.out.println("D" + k + "=    ");
                System.out.print("   ");

                for (int a = 0; a < letters.length; a++) {
                    System.out.printf("%-2c  ", letters[a]);
                }
                System.out.println();
                int index = 0;
                for (int f = 0; f < nV; ++f) {
                    System.out.print(letters[index]);
                    System.out.print("  ");

                    for (int g = 0; g < nV; ++g) {
                        if (matrix[f][g] == INF) {
                            System.out.printf("%-2s  ", "∞ ");
                        } else {
                            System.out.printf("%-2d  ", matrix[f][g]);
                        }
                    }

                    System.out.println();
                    index++;
                }
                System.out.println("----------------------------------------------");

            }

        }
        if (r.equalsIgnoreCase("r1")) {
            System.out.println("The final result");
            printMatrix(matrix);
        }

    }

    void printMatrix(int matrix[][]) {
        System.out.print("   ");

        for (int a = 0; a < letters.length; a++) {
            System.out.printf("%-2c  ", letters[a]);
        }
        System.out.println();
        int index = 0;
      
        for (int i = 0; i < nV; ++i) {
            System.out.print(letters[index]);
            System.out.print("  ");  
            for (int j = 0; j < nV; ++j) {
                if (matrix[i][j] == INF) {
                    System.out.printf("%-2s  ", "∞ ");
                } else {
                    System.out.printf("%-2d  ", matrix[i][j]);
                }
            }
            System.out.println();
            index++;

        }
    }

}

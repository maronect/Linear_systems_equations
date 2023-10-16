package GaussMetodo;

import java.text.DecimalFormat;

public class Gauss{

    static void gauss(double [][] matrix){
        

        int lenMat = matrix.length;
        double[] variaveis = new double[lenMat];

        if(lenMat < matrix[0].length - 1){
            System.out.println("Solucao impossivel! Mais variaveis do que equações.");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                
            }
        }

        System.out.println("Estado inicial:\n");

        for (int p = 0; p < lenMat; p++) {
            for (int q = 0; q < matrix[0].length; q++) {
                System.out.printf("%.2f", matrix[p][q]);
                System.out.print("    ");
            }
            System.out.println();
        }
        System.out.println();
        /*[[1,  4,  3, 1],
           [2,  5,  4, 4],
           [1, -3, -2, 5] ] */
        
        for (int i = 0; i < lenMat- 1; i++) {
            System.out.println("Estado " + (i+1));
            for (int j = i + 1; j < lenMat; j++) {
                double fator = matrix[j][i] / matrix[i][i];
                for (int m = i; m < lenMat + 1; m++) {
                    matrix[j][m] = matrix[j][m] - fator * matrix[i][m];
                }
            }
            
            for (int p = 0; p < lenMat; p++) {
                for (int q = 0; q < matrix[0].length; q++) {
                    System.out.printf("%.2f", matrix[p][q]);
                    System.out.print("    ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Valor de cada incognita:");
        

        variaveis[lenMat - 1] = matrix[lenMat - 1][lenMat] / matrix[lenMat - 1][lenMat - 1];
        for (int i = lenMat - 2; i >= 0; i--) {
            double soma = 0;
            for (int j = i + 1; j < lenMat; j++) {
                soma += matrix[i][j] * variaveis[j];
            }
            variaveis[i] = (matrix[i][lenMat] - soma) / matrix[i][i];
        }

        DecimalFormat df = new DecimalFormat("#.##");
        
        for (int j = 0; j < variaveis.length; j++) {
            String duasCasas = df.format(variaveis[j]);

            double val = Math.round(variaveis[j]) * 100;

            System.out.print("Incognita numero " + (j + 1) + "  "+ duasCasas);
            System.out.println("; o que seria aproximadamente " + val / 100);
        }
    }

    public static void main(String[] args) {
        /*[[1,  4,  3, 1],
           [2,  5,  4, 4],
           [1, -3, -2, 5] ] */
        //double matrix [][] = {{1,4,3,1},{2,5,4,4},{1,-3,-2,5}};
        double alppy [][] = {{1,-1,-1,0}, {-0.3, -0.7, 0, -9},{0, 0.7, -0.5, 0}};
        gauss(alppy);
    }
}
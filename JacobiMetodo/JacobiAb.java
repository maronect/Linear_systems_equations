/**
 * JacobiAb
 */
import java.util.Scanner;
public class JacobiAb {
    private double stopCriteria;
    private int numberOfVariables;
    private double[][] extendedMatrix;
    private double[] xValues;
    private int k;
    
    public JacobiAb(double stopCriteria, int numberOfVariables){
        this.k = 0;
        this.stopCriteria = stopCriteria;
        this.numberOfVariables = numberOfVariables;
        this.extendedMatrix = new double[numberOfVariables][numberOfVariables +1];
        this.xValues = new double[numberOfVariables];
        startMatrix();
        startXValues();
        System.out.println(" k \t x \t \t x+1 \t \t E");
        calculate();
    }

    private void startMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Favor inserir os valores da matriz extendida");
        for(int i=0; i< this.extendedMatrix.length;i++){
            for(int j= 0; j<this.extendedMatrix[0].length; j++){
                int h =this.extendedMatrix[0].length;
                this.extendedMatrix[i][j] = sc.nextDouble();
            }
        }
    }

    private void startXValues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Favor inserir os valores iniciais de x");
        for(int i =0; i< this.xValues.length; i++){
            this.xValues[i] = sc.nextDouble();
        }
    }

    private void calculate(){
        double result = 0;
        double valueToDiv = 0;
        double[] xNextStep = new double[this.xValues.length];
        for(int i =0; i< xNextStep.length; i++){
            result = this.extendedMatrix[i][xNextStep.length];
            for(int j=0; j<xNextStep.length;j++){
                if( i == j){
                    valueToDiv = this.extendedMatrix[i][j];
                }else{
                    result += this.extendedMatrix[i][j] * this.xValues[j] * -1;
                }
            }
            double resultFinal = result / valueToDiv;
            resultFinal = Math.round((resultFinal* 100));
            resultFinal = resultFinal/100;
            xNextStep[i] = resultFinal;
        }
        double error = maxError(xNextStep);
      
        System.out.println(this.k + "\t" + arrayToString(xValues) + "\t" + arrayToString(xNextStep) + "\t" + error);
        if(error <= this.stopCriteria){
            System.out.println("criterio atingido");
        }else{
            this.xValues = xNextStep;
            this.k +=1; 
            calculate();
        }
    }

    private double maxError(double[] xNextStep){
      
        double highestError = Math.abs(xNextStep[0]-this.xValues[0]);
        highestError = highestError * 100;
        highestError = Math.round(highestError);
        highestError = highestError/100;
        for(int i =1; i< xNextStep.length; i++){
           double error = Math.abs(xNextStep[i]-this.xValues[i]);
            error = error * 100;
            error = Math.round(error);
            error = error/100;
           if(highestError < error){
            highestError = error;
           }
        }
        return highestError;
    }

    private String arrayToString(double[] array){
        String result = "[";
        for(int i =0; i< array.length; i++){
            result+= array[i];
            result+= "/";
        }
        result += "]";
        return result;
    }
}
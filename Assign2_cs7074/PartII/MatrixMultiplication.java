import java.util.*;

class MatrixMultiplication {
	
	public static double[][] multiply(double[][] m1, double[][] m2) {
        int m1Rows = m1.length;
        int m1Cols = m1[0].length;
        int m2Cols = m2[0].length;
        
        double[][] result = new double[m1Rows][m2Cols];
        
        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m1Cols; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter two integers spearated by a space for rows and columns: ");
    	int rows = input.nextInt();
        int cols = input.nextInt();
        
        //create matrix M1 with dimensions rows x columns
        double[][] m1 = new double[rows][cols];
        fillMatrixWithRandomValues(m1);
        
        //create matrix M2 with dimensions columns x rows
        double[][] m2 = new double[cols][rows];
        fillMatrixWithRandomValues(m2);
        
        //multiply M1 and M2
        double[][] result = multiply(m1, m2);
        
        //print the matrices
        System.out.println("Matrix M1:");
        printMatrix(m1);
        System.out.println("Matrix M2:");
        printMatrix(m2);
        System.out.println("Result Matrix M3:");
        printMatrix(result);
        
        input.close();
    }
    
    public static void fillMatrixWithRandomValues(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random() * 10; //random value between 0 and 9.999...
            }
        }
    }
    
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
    
    
    	
  

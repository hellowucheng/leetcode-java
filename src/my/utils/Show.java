package my.utils;

public class Show {

    public static void showMatrix(int[][] matrix){
        System.out.println("-----------------------------------");
        if (matrix == null || matrix.length == 0){
            System.out.println("null");
            System.out.println("-----------------------------------");
            return;
        }
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }
}

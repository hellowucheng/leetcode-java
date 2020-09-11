package my.utils;

import java.util.List;
import java.util.Map;

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

    public static void showArray(int[] nums) {
        System.out.println("-----------------------------------");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.println(nums[i]);
            }
            else {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println("-----------------------------------");
    }

    public static void showArray(List nums) {
        System.out.println("-----------------------------------");
        for (int i = 0; i < nums.size(); i++) {
            if (i == nums.size() - 1) {
                System.out.println(nums.get(i));
            }
            else {
                System.out.print(nums.get(i) + " ");
            }
        }
        System.out.println("-----------------------------------");
    }

    public static void showMap(Map map) {
        System.out.println("-----------------------------------");
        for (Object key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println("-----------------------------------");
    }
}

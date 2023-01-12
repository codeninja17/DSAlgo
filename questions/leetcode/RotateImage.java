package questions.leetcode;

/**
 * 48. Rotate Image
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
         for(int i= 0; i<matrix.length; i++) {
             for (int j= i; j < matrix[0].length; j++) {
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp;
             }
         }

         int start = 0;
         int end = matrix[0].length-1;

         while (start < end) {
             for(int i = 0; i < matrix.length; i++) {
                 int temp = matrix[i][start];
                 matrix[i][start] = matrix[i][end];
                 matrix[i][end] = temp;
             }
             start++;
             end--;
         }

         print2D(matrix);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(arr2);
    }

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)
        {
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }

    }


}

package TUF;


public class TwoDimensionalArray {

    public static void main(String[] args) {
        int [][] arr = {{2,3},{1,4},{5,9}};
        int row = arr.length;
        int column = arr[0].length;
        int total = (row * column) -1;
        for(int i= 0; i<=total; i++) {
            int vC = i % column;
            int vR = i / column;
            System.out.println(arr[vR][vC]);
        }
    }
}

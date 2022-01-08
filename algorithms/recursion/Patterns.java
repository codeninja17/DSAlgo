package algorithms.recursion;

public class Patterns {

    public void printPatterns(int n,int row,int col){
        if(col == row || row > n){
            col = 0;
            System.out.println();
            if(row > n){
                return;
            }
            else{
                printPatterns(n,row+1,col);
            }
        }else{
            System.out.print("* ");
            printPatterns(n,row,col+1);
        }

    }

    public static void main(String[] args) {
        Patterns patterns = new Patterns();
        patterns.printPatterns(5,1,0);
    }
}

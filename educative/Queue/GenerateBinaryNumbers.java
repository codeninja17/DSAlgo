package educative.Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    static void binaryNumberGeneration(int n){
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for(int i=1 ; i<=n;i++){
            String num = queue.remove();
            System.out.println(i + " : "+ num);
            queue.add(num + "0");
            queue.add(num + "1");
        }
    }

    public static void main(String[] args) {
        binaryNumberGeneration(10);
    }
}

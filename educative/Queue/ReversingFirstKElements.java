package educative.Queue;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingFirstKElements {

    public static Queue<Integer> reverseK(Queue<Integer> queue,int k){
        Stack<Integer> integerStack = new Stack<>();
        for(int i = 0; i<k;i++)
            integerStack.push(queue.remove());
        for(int i = 0 ; i<k;i++)
            queue.add(integerStack.pop());

        for (int i = 0 ; i<(queue.size()-k);i++){
            queue.add(queue.remove());
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        reverseK(queue,4);
        System.out.println(queue);
    }
}

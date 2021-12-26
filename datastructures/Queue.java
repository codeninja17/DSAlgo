package datastructures;


import java.util.Arrays;

public class Queue {


    private int[] queue;
    private int size;
    private int front;
    private int back;
    private int currentsize;

    public static Queue initQueue(int size){
         Queue queue = new Queue();
         queue.queue = new int[size];
         queue.size = size;
         queue.front = -1;
         queue.back = -1;
         queue.currentsize =0;
         return queue;
    }

    void enqueue(int num) throws Exception {
        if(isFull())
            throw new Exception("Queue is Full");
        currentsize++;
        back = (back+1)%size;
        queue[back] = num;
    }

    int dequeue() throws Exception {
        if(isEmpty())
            throw new Exception("Queue is empty");
        currentsize--;
        front = (front+1) % size;
        return queue[front];

    }

    boolean isFull(){
        return this.size == this.currentsize;
    }

    boolean isEmpty(){
        return this.currentsize == 0;
    }

    public static void main(String[] args) throws Exception {
        Queue queue = Queue.initQueue(5);
        for (int i = 0; i < 5 ;i++){
            queue.enqueue(i+1);
        }
        System.out.println(Arrays.toString(queue.queue));
//        System.out.println(queue.front);
//        System.out.println(queue.back);

        for (int i = 0 ; i< 2 ;i++){
            System.out.println("Dequeue: "+queue.dequeue());
        }

        queue.enqueue(13);
        queue.enqueue(34);
        System.out.println(Arrays.toString(queue.queue));

        System.out.println(queue.dequeue());

        System.out.println(Arrays.toString(queue.queue));

    }
}

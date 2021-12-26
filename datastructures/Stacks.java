package datastructures;

import java.util.Arrays;

public class Stacks {

    private int [] stack;
    private int top;
    private int size;

    private Stacks(){}

    public static Stacks initStack(int size){
        Stacks stacks = new Stacks();
        stacks.size = size;
        stacks.stack = new int[size];
        stacks.top = -1;
        return stacks;
    }

    void push(int num) throws Exception {
        if(isFull())
            throw new Exception("Stack Overflow");
        this.top++;
        this.stack[this.top] = num;
    }

    int pop() throws Exception {
        if(isEmpty())
            throw new Exception("Stack Underflow");
        return this.stack[this.top--];
    }

    boolean isFull(){
        return this.top == this.size -1;
    }

    boolean isEmpty(){
        return this.top == -1;
    }

    public static void main(String[] args) throws Exception {
        Stacks stacks = Stacks.initStack(5);
        for(int i = 0;i<5;i++){
            stacks.push(i);
        }
        System.out.println(Arrays.toString(stacks.stack));
        // stacks.push(1);
        for (int i = 0; i<5;i++){
            System.out.println(stacks.pop());
        }
    }

}

package educative.Queue;


import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stack;
    Stack<Integer> bufferStack;

    public static ImplementQueueUsingStacks getQueue(){
        ImplementQueueUsingStacks stacks = new ImplementQueueUsingStacks();
        stacks.stack = new Stack<>();
        stacks.bufferStack = new Stack<>();
        return stacks;
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() throws Exception {
        if(bufferStack.empty() && stack.empty()){
            throw new Exception("Queue is empty");
        }
        if(bufferStack.empty()){
            while (!stack.empty()){
                bufferStack.push(stack.pop());
            }
        }
        return bufferStack.pop();
    }


    public int peek() throws Exception {
        if(bufferStack.empty() && stack.empty()){
            throw new Exception("Queue is empty");
        }
        if(bufferStack.empty()){
                bufferStack.push(stack.pop());
        }
        return bufferStack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) throws Exception {
        ImplementQueueUsingStacks queueUsingStacks = ImplementQueueUsingStacks.getQueue();
        queueUsingStacks.push(1);
        queueUsingStacks.push(2);
        queueUsingStacks.push(3);
        System.out.println(queueUsingStacks.pop());
        System.out.println(queueUsingStacks.pop());
        System.out.println(queueUsingStacks.peek());
        System.out.println(queueUsingStacks.pop());
        queueUsingStacks.push(4);
        System.out.println(queueUsingStacks.pop());
        System.out.println(queueUsingStacks.empty());
    }

}

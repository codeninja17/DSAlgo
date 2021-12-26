package educative.Stack;

public class TwoStacksSingleArray {

    private int top1;
    private int top2;
    private int maxSize;
    private int[] arr;

    public  TwoStacksSingleArray getInstance(int maxSize){
        TwoStacksSingleArray instance = new TwoStacksSingleArray();
        instance.maxSize = maxSize;
        instance.arr = new int[maxSize];
        instance.top1 = -1;
        instance.top2 = maxSize;
        return instance;

    }

    void push1(int num) throws Exception {
        if((top2 - top1) < 1){
            throw new Exception("Stack 1 is full");
        }
        this.arr[++top1] = num;
    }

    void push2(int num) throws Exception {
        if((top2 - top1) < 1){
            throw new Exception("Stack 1 is full");
        }
        this.arr[--top2] = num;
    }

    int pop1() throws Exception {
     if(top1 < 0){
         throw new Exception("Stack underfllow");
     }
     return arr[top1--];
    }

    int pop2() throws Exception {
        if(top2>maxSize-1){
            throw new Exception("Stack underfllow");
        }
        return arr[top2++];
    }

    public static void main(String[] args) {

    }

}

package educative.grokking;

import java.util.HashMap;

public class FruitsIntoBaskets {

    public static int findLength(char[] arr) {
        HashMap<Character,Integer> basket_one = new HashMap<>();
        HashMap<Character,Integer> basket_two = new HashMap<>();

        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;
        int windowStart = 0;
        for(int i=0;i<arr.length;i++){
            if(basket_one.isEmpty() || basket_one.containsKey(arr[i])){
                basket_one.put(arr[i],basket_one.getOrDefault(arr[i],0)+1);
                currLength++;
            }else if(basket_two.isEmpty() || basket_two.containsKey(arr[i])){
                basket_two.put(arr[i],basket_two.getOrDefault(arr[i],0)+1);
                currLength++;
            }else{
                char c = arr[windowStart];
                if(basket_one.containsKey(c)){
                    basket_one.remove(c);
                    basket_one.put(arr[i],basket_one.getOrDefault(arr[i],0)+1);
                }else if(basket_two.containsKey(c)){
                    basket_two.remove(c);
                    basket_two.put(arr[i],basket_two.getOrDefault(arr[i],0)+1);
                }
                windowStart++;
            }

            if(maxLength < currLength){
                maxLength = currLength;
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        char [] chars = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(findLength(chars));
    }

}

package questions.leetcode;

import java.util.HashMap;

/**
 * 904. Fruit Into Baskets
 */
public class FruitsIntoBaskets {

    public static int findLength(int [] fruits) {
        HashMap<Integer,Integer> basket_one = new HashMap<>();
        HashMap<Integer,Integer> basket_two = new HashMap<>();

        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;
        int windowStart = 0;
        for(int i=0;i<fruits.length;i++){
            if(basket_one.isEmpty() || basket_one.containsKey(fruits[i])){
                basket_one.put(fruits[i],basket_one.getOrDefault(fruits[i],0)+1);
                currLength++;
            }else if(basket_two.isEmpty() || basket_two.containsKey(fruits[i])){
                basket_two.put(fruits[i],basket_two.getOrDefault(fruits[i],0)+1);
                currLength++;
            }else{
                while(!basket_one.isEmpty() && !basket_two.isEmpty()){
                    int num = fruits[windowStart];
                    if(basket_one.containsKey(num)){
                        basket_one.put(num,basket_one.get(num)-1);
                        currLength-=1;
                        if(basket_one.get(num) <= 0) {
                            basket_one.remove(num);
                        }
                    }
                    else if(basket_two.containsKey(num)){
                        basket_two.put(num,basket_two.get(num)-1);
                        currLength-=1;
                        if(basket_two.get(num) <= 0) {
                            basket_two.remove(num);
                        }
                    }
                    windowStart++;
                }
                if(basket_one.isEmpty()){
                    basket_one.put(fruits[i],basket_one.getOrDefault(fruits[i],0)+1);
                }
                else{
                    basket_two.put(fruits[i],basket_two.getOrDefault(fruits[i],0)+1);
                }
                currLength++;
            }

            if(maxLength < currLength){
                maxLength = currLength;
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        int [] trees = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(findLength(trees));
    }

}

package questions.hackkerank;

import java.util.ArrayList;
import java.util.List;

public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int start = 0;
        int end =0;
        if(!a.isEmpty()){
            start = a.get(a.size()-1);
        }
        if(!b.isEmpty()){
            end = b.get(0);
        }
        int count = 0;
        if(!a.isEmpty() && !b.isEmpty()){
            for(int i = start ; i<=end ; i++){
                boolean first_array_flag = true;
                boolean second_array_flag = true;
                for (Integer integer : a) {
                    if (i % integer != 0) {
                        first_array_flag = false;
                        break;
                    }
                }

                for (Integer integer : b) {
                    if (integer % i != 0) {
                        second_array_flag = false;
                        break;
                    }
                }

                if(second_array_flag && first_array_flag){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        System.out.println(getTotalX(a,b));
    }
}

package questions.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 22. Generate Parentheses
 */
public class Generateoaranthesis {

    public static List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        generate(n,0,0,0,"",res);
        return new ArrayList<>(res);
    }

    public static void generate(int n, int open , int closed, int total, String currRes, Set<String> stringSet){
        if(total >= n*2){
            stringSet.add(currRes);
            return;
        }
             if(open < n){
                generate(n,open+1,closed,total+1,currRes+"(",stringSet);
            }
            if(closed < n && closed < open){
                generate(n,open,closed+1,total+1,currRes+")",stringSet);
            }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }

}

package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<String,Integer> romanIntegerMap = new HashMap<>();
        romanIntegerMap.put("I",1);
        romanIntegerMap.put("V",5);
        romanIntegerMap.put("X",10);
        romanIntegerMap.put("L",50);
        romanIntegerMap.put("C",100);
        romanIntegerMap.put("D",500);
        romanIntegerMap.put("M",1000);
        romanIntegerMap.put("IV",4);
        romanIntegerMap.put("IX",9);
        romanIntegerMap.put("XL",40);
        romanIntegerMap.put("XC",90);
        romanIntegerMap.put("CD",400);
        romanIntegerMap.put("CM",900);

        int sum = 0;
        for (int i=0;i<s.length();i++){
            String str = s.charAt(i) +"";
            if(str.equals("I") || str.equals("X") || str.equals("C")){
                if(i+1 < s.length()) {
                    str = str + s.charAt(i+1);
                    if(romanIntegerMap.containsKey(str)) {
                        sum += romanIntegerMap.get(str);
                        i++;
                    }
                    else sum += romanIntegerMap.get(str.substring(0,1));
                }   else sum += romanIntegerMap.get(str);
            }
            else {
                sum+=romanIntegerMap.get(str);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}

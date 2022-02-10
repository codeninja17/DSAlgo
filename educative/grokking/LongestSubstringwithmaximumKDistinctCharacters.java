package educative.grokking;

import java.util.HashMap;

public class LongestSubstringwithmaximumKDistinctCharacters {

    public static int findLength(String str, int k) {
        int windowStart = 0;
        int maxSubArray = Integer.MIN_VALUE;
        int currSubArr = 0;
        int uniqueCharCount = 0;
        HashMap<Character,Integer> characterIntegerHashMap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            if(!characterIntegerHashMap.containsKey(c)){
                uniqueCharCount++;
                characterIntegerHashMap.put(c,1);
            }else{
                characterIntegerHashMap.put(c,characterIntegerHashMap.get(c)+1);
            }

            if(uniqueCharCount <= k){
                currSubArr++;
                if(maxSubArray < currSubArr){
                    maxSubArray = currSubArr;
                }
            }else{
                while(uniqueCharCount > k){
                    if(characterIntegerHashMap.get(str.charAt(windowStart)) == 1){
                        characterIntegerHashMap.remove(str.charAt(windowStart));
                    }else{
                        characterIntegerHashMap.put(str.charAt(windowStart)
                                ,characterIntegerHashMap.get(str.charAt(windowStart))-1);
                    }
                    windowStart++;
                    uniqueCharCount--;
                    currSubArr--;
                }
                currSubArr++;
                if(currSubArr < maxSubArray){
                    maxSubArray =currSubArr;
                }
            }
        }
        return maxSubArray;
    }

    public static void main(String[] args) {
        String str ="cbbebi";
        System.out.println(findLength(str,10));
    }

}

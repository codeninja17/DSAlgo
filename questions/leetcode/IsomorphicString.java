package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic(String s , String t){

        Map<Character,Character> characterHashMap1 = new HashMap<>();
        Map<Character,Character> characterHashMap2 = new HashMap<>();
        for(int i = 0; i<s.length() ; i++){
          Character c = s.charAt(i);
          Character d = t.charAt(i);

          Character sMap = characterHashMap1.get(c);
          Character tMap =characterHashMap2.get(d);

          if(sMap!=null && tMap!=null){
              if(!(sMap.equals(d) && tMap.equals(c))) return false;
          }

          if(sMap == null && tMap != null){
              if(!tMap.equals(c)) return false;

          }

          if(sMap!=null && tMap==null){
              if(!sMap.equals(d)) return false;
          }
             characterHashMap1.put(c,d);
             characterHashMap2.put(d,c);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "baba";
        String t = "badc";

        IsomorphicString isomorphicString = new IsomorphicString();
        System.out.println(isomorphicString.isIsomorphic(s,t));
    }
}

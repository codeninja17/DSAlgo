package algorithms.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StringOps {

    public List<String> getSubsequence(String s){
        List<String> resultList = null;
        if(s.length() == 0){
            resultList = new ArrayList<>();
            resultList.add("");
            return resultList;
        }
        char c = s.charAt(0);
        resultList = getSubsequence(s.substring(1));
        resultList.add(c+"");
        ListIterator<String> iterator = resultList.listIterator();
        while(iterator.hasNext()){
            String str  = iterator.next();
            if(!str.isEmpty() && !str.equals(c+"")){
                iterator.add(c + str);
            }
        }
        return resultList;
    }
    public void printSubSequence(String s,String result){
        if(s.length() == 0){
           System.out.println(result);
           return;
        }
        char c = s.charAt(0);
        printSubSequence(s.substring(1),result);
        printSubSequence(s.substring(1),result+c);
    }

    public List<String> getPermutations(String str){
        if(str.length() == 0){
            List<String> baseCaseRes = new ArrayList<>();
            baseCaseRes.add("");
            return baseCaseRes;
        }

        List<String> resultList = new ArrayList<>();
        char c = str.charAt(0);
        String remStr = str.substring(1);
        List<String> recRes = getPermutations(remStr);

        for(String s : recRes){
            if(s.isEmpty()){
                resultList.add(c+"");
            }
            else {
                for(int i = 0 ; i<=s.length();i++){
                    resultList.add(s.substring(0,i) + c + s.substring(i));
                }
            }

        }
        return resultList;
    }

    public void printPermutations(String str , String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        for(int i = 0 ; i<str.length() ;i++){
            char c = str.charAt(i);
            String resStr = str.substring(0,i) + str.substring(i+1);
            printPermutations(resStr,c + ans);
        }
    }

    public static void main(String[] args) {
        StringOps stringOps = new StringOps();
        System.out.println(stringOps.getSubsequence("abc"));
        System.out.println(stringOps.getPermutations("abc"));
        // stringOps.printSubSequence("abc","");
        stringOps.printPermutations("abc","");
    }

}

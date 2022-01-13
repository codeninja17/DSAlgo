package questions.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1079. Letter Tile Possibilities
 */
public class LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        return getPermutations(tiles).size();
    }

    public Set<String> getPermutations(String str){
        if(str.length() == 0){
            return new HashSet<>();
        }

        Set<String> resultSet = new HashSet<>();
        char c = str.charAt(0);
        String remStr = str.substring(1);
        Set<String> recRes = getPermutations(remStr);
        resultSet.addAll(recRes);
        if(recRes.isEmpty()){
            resultSet.add(c+"");
        }
        else{
            resultSet.add(c+"");
            for(String s : recRes){
                for(int i = 0 ; i<=s.length();i++) {
                    resultSet.add(s.substring(0, i) + c + s.substring(i));
                }
            }
        }
        return resultSet;
    }

    public static void main(String[] args) {
        LetterTilePossibilities letterTilePossibilities = new LetterTilePossibilities();
        System.out.println(letterTilePossibilities.numTilePossibilities("AAB"));
        System.out.println(letterTilePossibilities.numTilePossibilities("AAABBC"));
        System.out.println(letterTilePossibilities.numTilePossibilities("A"));
        System.out.println(letterTilePossibilities.numTilePossibilities(""));

    }



}

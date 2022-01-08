package algorithms.backtracking;

public class CoinChangeSum {

    public static void printCoinChangeCombinations(int [] denominations ,
                                                   int amount , String ans , int lastDenomIndex ){
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        for(int i = lastDenomIndex ; i < denominations.length ; i++){
            if(amount >= denominations[i])
                printCoinChangeCombinations(denominations,amount - denominations[i],ans+denominations[i],i);
        }
    }

    public static void main(String[] args) {
        int [] denom = {2,3,5,6};
        CoinChangeSum.printCoinChangeCombinations(denom,15,"",0);
    }

}

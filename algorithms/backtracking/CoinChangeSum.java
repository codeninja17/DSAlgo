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

    public static void printCoinChangeCombinationsWithCoinRespect(int [] denominations ,
                                                   int amount , String ans , int lastDenomIndex ){
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        if(lastDenomIndex == denominations.length){
            return;
        }

        for(int i = lastDenomIndex ; i < denominations.length ; i=i+2){
            if(amount >= denominations[i]){
                printCoinChangeCombinationsWithCoinRespect
                        (denominations,amount - denominations[i],ans+denominations[i],i);
                if((i+1) < denominations.length){
                    printCoinChangeCombinationsWithCoinRespect
                            (denominations,amount - denominations[i+1],ans+denominations[i+1],i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] denom = {2,3,5,6};
        CoinChangeSum.printCoinChangeCombinations(denom,15,"",0);
        CoinChangeSum.printCoinChangeCombinationsWithCoinRespect(denom,15,"",0);
    }

}

package questions.leetcode;

public class NextLetter {

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while (start<=end){
            int mid = (end-start)/2 + start;
            if(letters[mid] == target && letters[(mid+1) % letters.length]!= target) return letters[(mid+1) % letters.length];
            else if(letters[mid] <= target){
                start = mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return letters[(start) % letters.length];
    }

    public static void main(String[] args) {
        char[] chars = {'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(nextGreatestLetter(chars,'e'));
    }

}

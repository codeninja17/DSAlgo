package questions.leetcode;

/**
 *  https://leetcode.com/problems/h-index-ii/
 *  275. H-Index II
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length == 1) return citations[0] == 0 ? 0 :1;
        return findHIndex(citations,0,citations.length-1,0,0);
    }

    public int findHIndex(int[] citations,int start, int end,int hIndex,int hindexVal){
        if(start == end || start>end){
            int elementsToRightOfHindex = (citations.length-hindexVal)-1;
            int elementsToRIghtOfStart = (citations.length-start)-1;
            if(elementsToRightOfHindex >= elementsToRIghtOfStart){
                if(elementsToRightOfHindex > hIndex)
                    return elementsToRightOfHindex;
                else return hIndex;
            }
            else{
                if(elementsToRIghtOfStart >= citations[start])
                    return elementsToRIghtOfStart;
                else return citations[start];
            }
        }

        int mid = (start+end)/2;
        int elementsToRight = citations.length-mid;
        if(elementsToRight >= citations[mid]){
            hIndex = citations[mid];
            hindexVal = mid;
            return findHIndex(citations,mid+1,end,hIndex,hindexVal);
        }
        else return findHIndex(citations,start,mid-1,hIndex,hindexVal);
    }

    public static void main(String[] args) {
        int [] citations = {0,1,6,7,8};
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(citations));
    }
}

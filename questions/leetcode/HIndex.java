package questions.leetcode;

/**
 *  https://leetcode.com/problems/h-index-ii/
 *  275. H-Index II
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length == 1) return citations[0] == 0 ? 0 :1;
        return findHIndex(citations,0,citations.length-1,0);
    }

    public int findHIndex(int[] citations,int start, int end,int hIndex) {
        if (start > end) {
         return hIndex;
        }
            int mid = (start + end) / 2;
            int elementsToRight = citations.length - mid;
            if(citations[mid] > mid){
                if(elementsToRight <= citations[mid]) {
                    if(elementsToRight >= hIndex)
                        hIndex=elementsToRight;
                }else hIndex = citations[mid];
                return findHIndex(citations,start,mid-1,hIndex);
            }else {
                if(citations[mid] >= hIndex)
                    hIndex = citations[mid];
                return  findHIndex(citations,mid+1,end,hIndex);
            }
        }

    public static void main(String[] args) {
        int [] citations = {0,1};
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(citations));
    }
}

package questions.leetcode;

/**
 * First Bad Version
 */

class VersionControl{
    boolean isBadVersion(Integer version){
        return version >= 1702766719;
    }
}

public class FirstBadVersion extends VersionControl{

    public int firstBadVersion(int n) {
        if(n == 1){
            if(isBadVersion(n)) return 1;
            else return -1;
        }
        return findFirstBadVersion(n,0,n);
    }

    public int findFirstBadVersion(int n,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = start+ (end-start)/2;
        if(isBadVersion(mid)){
            if((mid-1)>-1 && isBadVersion(mid-1)) return findFirstBadVersion(n,start,mid-1);
            else return mid;
        }
        else {
            return findFirstBadVersion(n,mid+1,end);
        }
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(2126753390));
    }
}

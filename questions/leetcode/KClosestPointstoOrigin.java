package questions.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 */
public class KClosestPointstoOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> calculateDistance(o2[0],o2[1])
                - calculateDistance(o1[0],o1[1]));
        for(int i = 0 ; i<points.length;i++){
            int [] point = points[i];
            if(priorityQueue.size() == k){
                int [] p = priorityQueue.peek();
                int distance = calculateDistance(p[0],p[1]);
                int currPointDistance = calculateDistance(point[0],point[1]);
                if(distance > currPointDistance){
                    priorityQueue.poll();
                    priorityQueue.offer(point);
                }
            }else priorityQueue.offer(point);
        }

        int [] [] res = new int[priorityQueue.size()][];
        int j = 0;
        while (!priorityQueue.isEmpty()){
            res[j++] = priorityQueue.poll();
        }
        return res;
    }

    public static int calculateDistance(int x , int y){
        return (x * x + y * y);
    }

    public static void main(String[] args) {
        int [] [] points = {{1,3},{-2,2}};
        System.out.println( Arrays.deepToString(kClosest(points,1)));
    }





}

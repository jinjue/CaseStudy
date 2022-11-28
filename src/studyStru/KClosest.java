package studyStru;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，
 * 返回离原点 (0,0) 最近的 k 个点。
 *可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的
 */
public class KClosest {

    public int[][] kClosest(int[][] points, int k) {
        //创建一个元素为数组的堆
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        //将points中的前k个结点计算出平方和后放入
        for(int i = 0; i<k;i++){
            heap.offer(new int[]{points[i][0]*points[i][0]+points[i][1]*points[i][1],i});
        }
        //从k+1个结点开始遍历后续节点
        for(int i = k; i<points.length ;i++) {
            //获取当前节点的平方和
            int dis = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            //比较当前节点的平方和与堆顶元素之间的大小，若小于
            if(dis < heap.peek()[0]){
                System.out.println(heap.peek()[1]);
                //则弹出堆顶元素
                heap.poll();
                //将当前节点存入堆中
                heap.offer(new int[]{dis,i});
            }

        }
        //创建返回的二维数组
        int[][] res = new int[k][2];
        //将堆中元素放入二维数组中
        for(int i = 0;i<k;i++){
            res[i] = points[heap.poll()[1]];
        }
        return res;
    }
}

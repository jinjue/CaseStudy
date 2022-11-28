package studyStru;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 */
public class IntervalMerge {

    public static int[][] merge(int[][] intervals) {

        //排除掉空，以及长度为1的情况
        if(intervals == null || intervals.length == 1)
            return intervals;
        //对intervals数组进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //将第一个区间放入返回的res中
        List<int[]> res = new ArrayList<int[]>();

        //按照行遍历intervals
        for(int i = 0; i<intervals.length ;i++){
            int left = intervals[i][0],right = intervals[i][1];
            //若前一个的右边界小于后一个的左边界，那么会不发生重叠，则添加元素
            //或链表为空，添加元素
            if(res.size() == 0 || res.get(res.size()-1)[1] < left){
                res.add(new int[]{left,right});
            }
            else {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],right);
            }

        }
        return res.toArray(new int[res.size()][]);
    }



}

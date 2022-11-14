package studyStru.sort;

import java.util.ArrayList;

/**
 * 桶排序的实现
 */
public class MyBucketSort {

    public static void bucketSort(int[] nums){
        //创建桶用于排序
        ArrayList bucket[] = new ArrayList[10];
        for (int i = 0; i < bucket.length ; i++){
            bucket[i] = new ArrayList<Integer>();
        }
        //将元素存入桶中
        for(int i = 0 ;i<nums.length-1; i++){
            int index = nums[i]/10;
            bucket[index].add(nums[i]);
        }
        //对桶中元素进行排序
        int k = 0;
        for (int i = 0; i < bucket.length ; i++){
            bucket[i].sort(null);
            for(int j = 0; j<bucket[i].size() ;j++){
                nums[k] = (int) bucket[i].get(j);
                System.out.print(nums[k] + " ");
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 45, 32, 23, 22, 31, 47, 24, 4, 15 };
        bucketSort(nums);
    }
}

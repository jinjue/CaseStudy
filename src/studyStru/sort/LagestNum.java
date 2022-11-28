package studyStru.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 */
public class LagestNum {

    public static String largestNumber(int[] nums) {
        if(nums.length == 0)
            return null;
        Integer[] bucket = new Integer[nums.length];
        for(int i = 0;i<nums.length;i++){
            bucket[i] = nums[i];
        }
        Arrays.sort(bucket,(a,b)->{
            String str1 = String.valueOf(a);
            String str2 = String.valueOf(b);
            return (str2 + str1).compareTo(str1+str2);
        });
        if(bucket[0]==0)
            return "0";
        StringBuilder res = new StringBuilder();
        for (Integer number : bucket) {
            res.append(number);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

}

package studyStru.sort;

import java.util.Arrays;

/**
 * 选择排序的实现
 */
public class MyChoseSort {

    public static int[] choseSort(int[] nums){
        int borden = 0;
        for(int i = 0; i<nums.length ; i++){
            int min = borden;
            for(int j = borden+1; j<nums.length;j++){
                if(nums[min]>nums[j]){
                    min = j;
                }
            }
            if(min != borden){
                int temp = nums[min];
                nums[min] = nums[borden];
                nums[borden] = temp;
            }
            borden ++;
        }
        return nums;
    }

    public static void print(int[] nums){
        System.out.println("nums=" + Arrays.toString(nums) );
    }

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,1,2,3,4};
        print(nums);
        nums = choseSort(nums);
        print(nums);
    }
}

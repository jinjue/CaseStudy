package studyStru.sort;

import java.util.Arrays;

/**
 * 冒泡排序的实现
 */
public class MyBubbleSort {

    public static int[] bubble(int[] nums){
        for(int i = 0;i<nums.length-1;i++){
            for(int j = 0; j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] bubble2(int[] nums){
        int borden = nums.length-1;
        int lastChange = 0;
        for(int i = 0;i<nums.length-1;i++){
            boolean isSort = true;
            for(int j = 0; j<borden;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSort = false;
                    lastChange = j;
                }
            }
            if(isSort)
                break;
            borden = lastChange;

        }
        return nums;
    }


    public static void print(int[] nums){
        System.out.println("nums=" + Arrays.toString(nums) );
    }


    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,1,2,3,4};
        print(nums);
        nums = bubble2(nums);
        print(nums);
    }
}

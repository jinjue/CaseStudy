package studyStru.sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 实现基数循环
 */
public class MyBaseSort {

    public static void baseSort(int[] nums){
        //创建10个桶用于存放元素
        LinkedList<Integer>[] bucket = new LinkedList[10];
        for(int i = 0; i < bucket.length ;i++ ){
            bucket[i] = new LinkedList<>();
        }
        //确定最大位数->循环次数
        int digit = getDigit(nums);
        //循环将元素按照个位、十位...的数值存入对应0-9的桶中
        for(int i = 1; i <= digit ; i ++ ){
            //对应循环，获取元素对应位数上的数值，不足补0
            for(int j = 0; j < nums.length; j++){
                //根据位数存入对应桶中
                bucket[getIndex(nums[j],i)].offer(nums[j]);
            }
            //依次取出桶中元素，再按照下一位位数进行操作
            nums = getNums(bucket,nums.length);
        }
    }

    /**
     * 获取数组中最大元素的位数
     * @param nums
     * @return
     */
    public static int getDigit(int[] nums){
        int max = nums[0];
        for(int i = 1; i<nums.length ; i++){
            if(max <nums[i])
                max = nums[i];
        }
        int digit = 1;
        while (true){
            max = max/10;
            if (max == 0){
                System.out.println("maxDigit : "+digit);
                return digit;
            }

            digit ++;
        }

    }

    /**
     * 获取数据的位数
     * @param num
     * @param digit
     * @return
     */
    public static int getIndex(int num, int digit){
        int index = 0 ;
        for(int i = 1;i <= digit; i++){
            index = num%10;
            num = num/10;
        }
        return index;
    }

    public static int[] getNums(LinkedList<Integer>[] bucket,int size){
        int[] nums = new int[size];
        int j = 0;
        System.out.println("nums : ");
        for(int i = 0; i<bucket.length ;i++){
            while (!bucket[i].isEmpty()){
                nums[j] = bucket[i].poll();
                System.out.print(" "+ nums[j]);
                j++;
            }
        }
        System.out.println();
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 545, 32, 23, 232, 931, 47, 624, 4, 15 };
        baseSort(nums);
    }
}

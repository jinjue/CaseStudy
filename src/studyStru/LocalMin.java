package studyStru;

/**
 * 实现局部最小
 * 有一无序数组，现要求找到一个该数组中的局部最小值
 * 局部最小：若索引i = 0，小于右边值，则为局部最小；若i = length-1，小于左边值，则局部最小
 * 若i位于中间位置，则左边<i<右边，则i局部最小
 */
public class LocalMin {

    /**
     * 找到局部最小的实现方法
     * @param nums 无序数组
     * @param start 开始查找的位置
     * @param end 结束查找的位置
     * @return
     */
    public static int findLocalMin(int[] nums,int start ,int end){
        //若数组长度小于2，则无局部最小
        //若start>=end则越界，说明没有局部最小，返回-1
        if(nums.length < 2 || start >= end)
            return -1;
        //若nums[0]<nums[1]，则nums[0]为局部最小
        if(nums[0]<nums[1])
            return nums[0];
        //若数组尾部小于左边值，则局部最小
        if( nums[nums.length-1]<nums[nums.length-2])
            return nums[nums.length-1];
        //求取中间值
        int mid = start +(end-start)/2;
        //判断中间值是否是局部最小
        if(nums[mid] <nums[mid-1] && nums[mid]<nums[mid+1]){
            return nums[mid];
        }
        else if(nums[mid] >= nums[mid-1]){//若中间值大于左边值
            return findLocalMin(nums, start, mid-1);
        }
        else {//若中间值大于右边值
            return findLocalMin(nums,mid+1,end);
        }

    }

    public static void main(String[] args) {
        int[] nums = {4,2,6,3,7,8,1,6,9};
        System.out.println(findLocalMin(nums,0,nums.length-1));
    }

}

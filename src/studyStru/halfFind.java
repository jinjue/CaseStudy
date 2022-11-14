package studyStru;

/**
 * 实现二分查找
 * 时间复杂度:O(log n)
 */
public class halfFind {

    /**
     * 二分查找的实现
     * @param nums 一个升序数组
     * @return
     */
    public static int halfSearch(int[] nums, int left, int right,int data){
        //对nums进行判断，若为null则直接返回
        if(nums.length == 0)
            return -1;
        //若left>right则返回-1
        if(left > right)
            return -1;
        //获取中间元素
        int mid = left+(right - left)/2;
        //比较中间元素和需要查找的元素进行比较，若等于，则返回中间索引
        if(nums[mid] == data)
            return mid;
        //若大于则继续查找左边部分
        else if(nums[mid] >data)
            return halfSearch(nums,left,mid-1,data);
        //若小于则继续查找右边部分
        else
            return halfSearch(nums,mid+1,right,data);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(halfSearch(nums,0,nums.length-1,8));
    }

}

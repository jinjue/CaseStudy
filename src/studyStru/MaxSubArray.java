package studyStru;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray {

    public int maxArray(int[] nums) {
        if(nums == null)
            return 0;
        int res = nums[0];
        int max = 0;
        for(int i = 0;i<nums.length ;i++){
            if(max > 0)
                max += nums[i];
            else
                max = nums[i];
            res = Math.max(max,res);
        }
        return res;
    }
}

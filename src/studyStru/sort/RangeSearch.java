package studyStru.sort;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 */
public class RangeSearch {

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int isFind = search(nums,target,0,nums.length-1,res);
        if(isFind == 1 && res[0] == 0 && res[1] == 0){
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }

    public static int search(int[] nums, int target, int left, int right,int[] res){
        if(left > right){
            return -1;
        }
        int mid = left + (right-left)/2;
        if(nums[mid] == target){
            if(res[0] == 0){
                res[0] = mid;

            }
            else {
                System.out.println("mid :"+mid);
                res[0] = Math.min(res[0],mid);
                res[1] = Math.max(res[1],mid);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums,8);
        System.out.println(res[0]+" "+res[1]);
    }

}

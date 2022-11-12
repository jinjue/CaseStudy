package studyStru;

/**
 * 寻找一个数据随机分布的数组中第K大的值
 */
public class TopK {

    //暴力求解，直接将整个数组进行排序，再输出第K大的数
    //利用快排每次遍历都会有一个元素到达最终位置的特点求解
    public static int findTopK(int[] nums,int k){
        if(k > nums.length || k<0 || nums.length ==0)
            return -1;
        //计算出需要查找的k对应的索引下标
        int index = nums.length - k;
        //获取结果
        int result = arrayFastSort(nums,0,nums.length-1,index);
        return result;
    }

    /**
     * 实现快排
     * @param nums
     * @param start
     * @param end
     */
    public static int arrayFastSort(int[] nums,int start,int end,int k){
        int point = arrayFast(nums,start,end);
        //递归终止条件：如果遍历完返回的索引就是对应的k的索引，则直接返回
        if(point == k){
            return nums[point];
        }
        //如果不是，则k位于左边或者右边
        //判断k位于左边还是右边
        int result = 0;
        if(point>k){
            result = arrayFastSort(nums,start,point-1,k);
        }
        else {
            result = arrayFastSort(nums,point+1,end,k);
        }
        return result;
    }

    public static int arrayFast(int[] nums,int start,int end){
        //快排的每一次遍历
        int point = nums[start];
        int low = start;
        int high = end;
        while (low!=high){
            while (low<high && nums[high] > point)
                high--;
            while (low<high && nums[low] <= point)
                low++;
            if(low<high ){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }
        nums[start] = nums[low];
        nums[low] = point;

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        System.out.println(findTopK(nums,k));
    }
}

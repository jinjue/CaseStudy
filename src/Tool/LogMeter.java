package Tool;

/**
 * 对数器的模板
 */
public class LogMeter {

    public int maxSize;
    public int maxValue;

    public LogMeter(int maxSize, int maxValue) {

        this.maxSize = maxSize;
        this.maxValue = maxValue;
    }

    /**
     * 创建一个长度随机、值随机的整型数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public int[] getRandomArray(int maxSize,int maxValue){
        int[] nums = new int[(int) (Math.random()*maxSize)];
        for(int i = 0 ;i < nums.length; i++){
            nums[i] = (int) (Math.random()*(maxValue+1)-Math.random()*maxSize);
        }
        return nums;
    }

    /**
     * 复制随机数组用于比较
     * @param nums
     * @return
     */
    public int[] copyRandomArray(int[] nums){
        if(nums == null)
            return null;
        int[] arr = new int[nums.length];
        for(int i = 0 ;i < nums.length; i++){
            arr[i] = nums[i];
        }
        return arr;
    }

    /**
     * 比较两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public boolean isEqual(int[] arr1,int[] arr2){
        if(arr1 == null && arr2 == null){
            return true;
        }
        else if(arr1 == null || arr2 == null){
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0 ;i < arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }


}

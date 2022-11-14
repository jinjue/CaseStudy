package studyStru.sort;

/**
 * 堆排序实现
 */
public class MyHeapSort {

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public static int[] heapSort(int[] nums){
        if(nums.length == 0)
            return nums;
        //根据数组构建堆（大根堆）
        int[] result = crateHeap(nums);
        //移动堆顶元素到数组末尾，完成排序
        sortNums(result);
        for(int i = 0;i<nums.length;i++){
            nums[i] = result[i+1];
        }
        return nums;
    }

    /**
     * 构建大根堆
     * @param nums
     * @return
     */
    public static int[] crateHeap(int[] nums){
        int[] arr = new int[nums.length+1];
        arr[0] = 0;
        //循环取出数组中元素插入堆末尾
        for(int i=0;i<nums.length;i++){
        //对元素进行上浮调整
            arr[0] ++;
            arr[i+1] = nums[i];
            upHeap(arr,arr[0]);
        }

        return arr;
    }
    /**
     * 将堆顶元素移动到末尾，最终形成升序。需要有无序和有序的边界
     */
    public static void sortNums(int[] nums){
        if(nums.length == 0)
            return;
        //循环输出栈顶元素，将输出的元素移动到末尾
        for(int i = nums.length-1; i>0 ; i--){
            //交换堆顶元素和无序部分最右边的元素
            int max = nums[1];
            nums[1] = nums[i];
            nums[i] = max;
            //对堆顶-边界的堆进行下沉调整
            downHeap(nums,i);
        }

    }
    /**
     * 上浮调整
     */
    public static void upHeap(int[] nums,int size){
        for(int i=size ; i>1 ; i--){
            if(nums[i/2] < nums[i]){
                int temp = nums[i/2];
                nums[i/2] = nums[i];
                nums[i] = temp;
            }
        }

    }

    /**
     * 下沉调整
     */
    public static void downHeap(int[] nums,int borden){
        for(int i = 1; i < borden/2 ; i++){
            int max = Math.max(nums[2*i],nums[2*i+1]);
            int index = nums[2*i]>nums[2*i+1]?2*i:2*i+1;
            if(nums[i] < max){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }

    public static void print(int[] nums){
        System.out.print("nums: ");
        for(int i = 0; i<nums.length;i++){
            System.out.print(" "+nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,7,6,9};
        nums = heapSort(nums);
        print(nums);
    }

}

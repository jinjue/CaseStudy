package studyStru;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断数据随机分布数组中是否有元素重复
 */
public class RepeatData {

    public static boolean isRepeat(int[] nums){
        if(nums.length <= 1)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length ;i++){
            if(map.containsKey(nums[i]))
                return true;
            map.put(nums[i],nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,4,7,8};
        System.out.println(isRepeat(nums));
    }
}

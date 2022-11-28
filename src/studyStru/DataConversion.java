package studyStru;

import java.util.HashMap;
import java.util.Map;

/**
 * 数字转换成字母
 * 规定1和A对应、2和B对应、3和C对应...
 * 那么一个数字字符串比如"111"，就可以转化为"AAA”、"KA"和"AK”。
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果。
 */
public class DataConversion {

    /**
     * 实现数字转化字母
     * @param arr 只包含数字的字符数组
     * @param i i位置上的可能结果
     * @return
     */
    public static int getAllKind(char[] arr,int i){
        //如果i位置上的字符为0，则直接返回0，因为不可能会对应字母，表示之前做的决定不合适，当前转化不了
        if(arr[i] == '0' )
            return 0;
        //如果i == arr.length,则返回1，表示之前做的决定是有效的;
        int kind = 0;
        //如果i位置上的字符为1之间
        if(arr[i] == '1') {
            //若i位置上的数为1，自己对应字母的可能情况

            //和i+1对应字母的可能情况，且i+1不越界
        }
        if(arr[i] == '2') {//若i位置上的数为2

            //自己对应字母的可能情况

            // i+1位置上的数<=6，，且i+1不越界。一起组合的可能情况

        }

        //如果i位置上的字符>=3，则只能自己对应字母
        return i;
    }
}

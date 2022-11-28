package studyStru;

import java.util.ArrayList;

/**
 * 求字符串子序列
 */
public class ChildStr {


    /**
     * 求字符串所有子序列，包括null
     * @param str
     * @param i
     */
    public static void getAllChild(char[] str,int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        //获取字符
        getAllChild(str, i+1);
        //不获取字符
        char temp = str[i];
        str[i] = 0;
        getAllChild(str,i+1);
        str[i] = temp;

    }


    /**
     * 求字符串全部排列，要求不能重复  (字符全为小写字符)
     * 输入：字符串、遍历指针i
     * 输出：字符串排列结果集
     *
     */
    public static void getAllArrange(char[] str,int i){
        //递归结束条件：i = str.length
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        //创建boolean数组用于去重
        boolean[] visited = new boolean[26];
        //遍历str
        for(int j = i; j<str.length ; j++){
            //只获取那些没有重复的字符串排列
            if(!visited[str[j] - 'a']){
                visited[str[j] - 'a'] = true;
                //交换i，j所指字符串
                swap(str,i,j);
                //继续遍历访问后续排列可能
                getAllArrange(str,i+1);
                //将i，j复原
                swap(str,i,j);
            }
        }

    }

    public static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    public static void main(String[] args) {
        String str = "bac";
        getAllChild(str.toCharArray(),0);


    }
}

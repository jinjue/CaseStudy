package studyStru;

/**
 * 字符串匹配算法KMP的实现
 */
public class MyKMP {

    /**
     * KMP的实现方法
     * @param str1
     * @param str2
     * @return
     */
    public static int KMP(char[] str1,char[] str2){
        //判断str1、str2的合法性
        if(str1 == null || str2 == null || str1.length < str2.length){
            return -1;
        }
        //获取next数组
        int[] next = getNext(str2);
        //创建两个指针用于遍历str1、str2
        int i =0 , j=0;
        //根据next数组对str1进行遍历，循环结束条件str1、str2有一个越界
        while(i<str1.length && j<str2.length){
            //若字符匹配，则指针向后移
            if(str1[i] == str2[j]){
                i++;
                j++;
            }
            else if(next[j] == -1) {//若字符不匹配，且next[j]为-1，则j移动到0位置
                j = 0;
                i++;
            }
            else {// 否则str2的指针j移动到next[j]所指的部分
                j = next[j];
            }
        }

        //判断出循环是因为str2越界匹配成功，还是str1越界匹配失败
        return j == str2.length?i-j:-1;
    }

    /**
     * 根据str子串生成对应的next数组
     * @param str
     * @return
     */
    public static int[] getNext(char[] str){
        //若str长度为1，则直接返回-1的数组
        if(str.length == 1)
            return new int[]{1};
        //认为设定next[0]、next[1]的值
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        //创建变量cn表示当前所指的字符的前一个字符最长公共前后缀的长度
        int cn = 0;
        //遍历str
        for(int i = 2; i<next.length ; i++){
            //若str[i-1] = str[cn]，则next[i] = cn +1；并移动指针向后
            if(str[i-1] == str[cn]){
                next[i] = ++cn;
            }
            else if(cn <= 0) {//若不等且next[cn] = -1，则cn = 0
                next[i] = 0;
            }
            else {//则cn = next[cn]，移动到前面判断cn位置之前的前后缀匹配
                cn = next[cn];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        char[] str1 = {'h','e','l','l','o','b','a','n','a','n','a'};
        char[] str2 = {'y','o','b'};
        System.out.println(KMP(str1,str2));
    }

}

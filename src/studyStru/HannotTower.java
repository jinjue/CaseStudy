package studyStru;

import java.util.ArrayList;

/**
 * 汉诺塔
 * 返回：移动的路径
 */
public class HannotTower {


    public static ArrayList<String> hannot( int level){
        //level 为0，直接返回null
        if(level <= 0)
            return null;
        //创建返回的字符串链表
        ArrayList<String> res = new ArrayList<>();
        //调用获取路径的方法
        getWay(level,"左","右","中",res);
        return res;
    }

    public static void getWay(int level, String from, String to,String other, ArrayList<String> res){
        //若只有一层，则直接从左移动到右
        if(level == 1){
            res.add("将第 "+level+" 的盘子从"+from+"移动到"+to+" .");
            return;
        }
        //将1~i-1层的盘子，从左移动到中
        getWay(level-1, from, other, to, res);
        //将最底层，第level层的盘子从左移动到右
        res.add("将第 "+level+" 的盘子从"+from+"移动到"+to+" .");
        //将1~i-1层的盘子，从中移动到右
        getWay(level-1,  other, to, from, res);
    }

    public static void main(String[] args) {

        ArrayList<String> res = hannot(3);
        for (String re : res) {
            System.out.println(re);
        }
    }

}

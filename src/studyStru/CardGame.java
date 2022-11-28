package studyStru;

/**
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。
 * 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。
 * 请返回最后获胜者的分数。
 *
 */
public class CardGame {

    public static int playGame(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        return Math.max(playPre(arr,0,arr.length-1),playAfter(arr, 0, arr.length-1));
    }


    /**
     * 纸牌游戏的先手摸牌
     * @param arr 代表不同数值的纸牌
     * @param left 代表被拿取和未被拿取的纸牌左边界
     * @param right 代表被拿取和未被拿取的纸牌右边界
     * @return 返回累积的分数
     */
    public static int playPre(int[] arr, int left, int right){
        //若左边界==右边界，则代表纸牌已经拿取完毕，结束递归
        if(left == right){
            return arr[left];
        }
        //取之后摸牌的最大值
        return Math.max(arr[left]+playAfter(arr, left+1, right),arr[right]+playAfter(arr, left, right-1));
    }

    /**
     * 纸牌游戏的后手
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int playAfter(int[] arr, int left, int right){
        //若不剩牌，则返回0；
        if(left == right)
            return 0;
        //若剩牌，则作为先手进行摸牌
        return Math.min(playPre(arr, left+1, right),playPre(arr, left, right-1));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,100,4};
        System.out.println(playGame(arr));
    }

}

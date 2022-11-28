package studyStru.DynPro;

/**
 *机器人走路
 * 在1~N的位置上，机器人从cur位置走到aim位置时必须要花费res步数，返回可以走的方法数
 * 当机器人在1位置时，只能往2走；当机器人在N位置时，只能往N-1走
 */
public class RobotWalking {

    /**
     *
     * @param cur 机器人所处的当前位置
     * @param res 机器人剩余走的步数
     * @param aim 机器人的目标位置
     * @param N 一共有哪些位置
     * @return
     */
    public static int walking(int cur,int res,int aim,int N){
        //如果机器人步数用完
        if(res == 0)
            return cur == aim ? 1:0;
        //如果当前位置是1
        if(cur == 1)
            return walking(2,res-1,aim,N);
        //若当前位置是N
        else if(cur == N)
            return walking(N-1,res-1,aim,N);
        //若当前位置位于中间
        else return walking(cur-1,res-1,aim,N) + walking(cur+1,res-1,aim,N);
    }

    public static int demo(int cur,int res,int aim,int N){
        if(res == 0){
            return res == aim ? 1:0;
        }
        if(cur == 1)
            return demo(2,res-1 , aim, N);
        else if(cur == N)
            return demo(N-1,res-1 , aim, N);

        return demo(cur+1,res-1 , aim, N) + demo(cur-1,res-1 , aim, N);

    }

    public static void main(String[] args) {

    }

}

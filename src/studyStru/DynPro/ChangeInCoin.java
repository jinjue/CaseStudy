package studyStru.DynPro;

import java.util.Arrays;

/**
 * 硬币找零问题
 * 给定 n 种不同面值的硬币，分别记为 c[0], c[1], c[2], … c[n]，假设每种硬币的数量是无限的。
 * 同时还有一个总金额 k，编写一个动态规划计算出最少需要几枚硬币凑出这个金额 k？
 */
public class ChangeInCoin {


    public static int collectNew(int[] coins, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int sum = 1; sum <= target; sum++) {
            for(int coin:coins) {
                if(sum<coin) {
                    continue;
                }
                dp[sum] = Math.min(dp[sum], dp[sum-coin]+1);
            }
        }
        return dp[target]==Integer.MAX_VALUE?-1:dp[target];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};

        System.out.println(collectNew(coins,12));
    }

}

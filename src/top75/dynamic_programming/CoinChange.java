package dynamic_programming;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0
 
*/
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int coinChange(int[] coins, int amount) {
        if(amount < 1) {
            return 0;
        }
        
        return coinChangeRecursive(coins, amount, new int[amount]);
    }
    
    public int coinChangeRecursive(int[] coins, int amount, int[] dp) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(dp[amount - 1] != 0) {
            return dp[amount - 1];
        }
        
        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int result = coinChangeRecursive(coins, amount - coin, dp);
            if(result >= 0 && result < min) {
                min = 1 + result;
            }
        }
        
        dp[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount - 1];
    }

}

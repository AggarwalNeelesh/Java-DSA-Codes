import java.util.*;
/*
Coin Change (Count Ways)
Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].

Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].

Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.

Constraints:
1 <= sum <= 103
1 <= coins[i] <= 104
1 <= coins.size() <= 103
*/


public class CoinChangePermutation{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int coins[] = {1, 2, 3};
        int sum = 4;
        System.out.println("Coins : "+Arrays.toString(coins) + " Sum : "+sum);
        CoinChangePermutation ccp = new CoinChangePermutation();
        int ways = ccp.count(coins, sum);
        System.out.println("Number of ways to make sum "+sum+" is : "+ways);
    }

    public int count(int coins[], int sum) {
        // code here.
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=sum;j++){
                if(j-coins[i] >=0){
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        return dp[sum];
    }

}
import java.util.*;
/*
Input: amount = 7, coins = [2,3,5]
Output: 5
Explanation: the possible permutations are:
223,232,322,25,52
*/

public class CoinChangePermutation{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int coins[] = {2, 3, 5};
        int sum = 7;
        System.out.println("Coins : "+Arrays.toString(coins) + " Sum : "+sum);
        int ways = count(coins, sum);
        System.out.println("Number of ways to make sum "+sum+" is : "+ways);
    }

    public static int count(int coins[], int sum) {
        // code here.
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for(int i=1;i<=sum;i++){
            for(int x: coins){
                if(i>=x){
                    dp[i] += dp[i-x];
                }
            }
        }
        return dp[sum];
    }
}
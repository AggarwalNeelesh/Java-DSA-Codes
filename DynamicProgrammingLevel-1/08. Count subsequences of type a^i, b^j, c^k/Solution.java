import java.util.*;
/*

Given a string S, the task is to count number of subsequences of the form aibjck, where i >= 1, j >=1 and k >= 1.

Note: 
1. Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
2.  For large test cases, the output value will be too large, return the answer MODULO 10^9+7

Example 1:
Input:
S = "abbc"
Output: 3
Explanation: Subsequences are abc, abc and abbc.

Example 2:
Input:
S = "abcabc"
Output: 7
Explanation: Subsequences are abc, abc,
abbc, aabc abcc, abc and abc.
*/
public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        String s = "abcabc";
        System.out.println("Input String: " + s);
        Solution obj = new Solution();
        int result = obj.fun(s);
        System.out.println(result);
        sc.close();
    }
    public int fun(String s) {
        // Write your code here
        long dp[][] = new long[s.length()+1][3];
        int MOD = 1_00_00_00_007;
        for(int i=1;i<=s.length();i++){
            if(s.charAt(i-1)=='a'){
                dp[i][0] = (dp[i-1][0]*2 + 1)%MOD;
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-1][2];
            }else if(s.charAt(i-1)=='b'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = (dp[i-1][1]*2 + dp[i][0])%MOD;
                dp[i][2] = dp[i-1][2];
            }else{
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
                dp[i][2] = (dp[i-1][2]*2 + dp[i][1])%MOD;
            }
        }
        return (int)dp[s.length()][2];
    }
}



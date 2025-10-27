import java.util.*;
/*
Given an array arr containing positive integers. Find the maximum sum of elements of any possible subsequence such that no two numbers in the subsequence should be adjacent in array arr[].

Examples:

Input: arr[] = [5, 5, 10, 100, 10, 5]
Output: 110
Explanation: If you take indices 0, 3 and 5, then = 5+100+5 = 110.
Input: arr[] = [3, 2, 7, 10]
Output: 13
Explanation: 3 and 10 forms a non continuous subsequence with maximum sum.
Input: arr[] = [9, 1, 6, 10]
Output: 19
Explanation: 9 and 10 forms a non continuous subsequence with maximum sum.
*/
public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = {5, 5, 10, 100, 10, 5};
        System.out.println("Input Array: " + Arrays.toString(arr));
        Solution obj = new Solution();
        int result = obj.findMaxSum(arr);
        System.out.println("Max Sum without Adjacent: " + result);
        sc.close();
    }
    public int findMaxSum(int arr[]) {
        // code here
        if(arr.length==2)return Math.max(arr[0], arr[1]);
        int dp[][] = new int[arr.length][2];
        dp[0][0] = arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i][0] = arr[i] + dp[i-1][1];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[arr.length-1][0], dp[arr.length-1][1]);
    }
}

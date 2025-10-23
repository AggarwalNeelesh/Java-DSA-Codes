import java.util.*;

public class TargetSumSubset{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println("Array : "+Arrays.toString(arr) + " Target Sum : "+target);
        boolean hasTargetSum = hasTargetSumSubset(arr, target);
        System.out.println("Has Target Sum Subset : "+hasTargetSum);

        int brr[] = {7, 4};
        target = 17;
        System.out.println("Array : "+ Arrays.toString(brr) + " Target Sum : "+target);
        hasTargetSum = hasTargetSumSubset(brr, target);
        System.out.println("Has Target Sum Subset : "+hasTargetSum);
    }
    static boolean hasTargetSumSubset(int nums[], int target) {
        // code here
        boolean dp[][] = new boolean[nums.length+1][target+1];
        dp[0][0] = true;
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=target;j++){
                if(j==0)dp[i][j] = true;
                else if(dp[i-1][j])dp[i][j] = true;
                else if(j - nums[i-1] >=0)dp[i][j] = dp[i-1][j-nums[i-1]];
            }
        }
        return dp[nums.length][target];
    }
}
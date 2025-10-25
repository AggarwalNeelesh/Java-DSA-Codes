import java.util.*;
/*
Given a set of items, each with a weight and a value, represented by the array wt and val respectively. Also, a knapsack with a weight limit capacity.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

Examples:

Input: val = [1, 1], wt = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times.

Input: val[] = [6, 1, 7, 7], wt[] = [1, 3, 4, 5], capacity = 8
Output: 48
Explanation: The optimal choice is to pick the 1st element 8 times.

Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
Output: 0
Explanation: We can't pick any element .hence, total profit is 0.
*/
public class UnboundedKnapSackWithRepeatation{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int val[] = {6, 1, 7, 7};
        int wt[] = {1, 3, 4, 5};
        int capacity = 8;
        System.out.println("wt : "+Arrays.toString(wt) + " val : "+Arrays.toString(val)+ " Capacity : "+capacity);
        int maxValue = knapSack(val, wt, capacity);
        System.out.println("Maximum value in Knapsack : "+maxValue);
    }

    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int dp[] = new int[capacity+1];
        for(int i=0;i<val.length;i++){
            for(int j=wt[i];j<=capacity;j++){
                dp[j] = Math.max(dp[j], dp[j-wt[i]] + val[i]);
            }
        }
        return dp[capacity];
    }

}






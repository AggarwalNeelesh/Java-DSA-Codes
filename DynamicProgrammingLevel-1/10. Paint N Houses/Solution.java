import java.util.*;
/*
Paint N Houses
Difficulty: MediumAccuracy: 51.33%Submissions: 28K+Points: 4
There is a row of N houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. Find the minimum cost to paint all houses.

The cost of painting each house in red, blue or green colour is given in the array r[], g[] and b[] respectively.


Example 1:
Input:
N = 3
r[] = {1, 1, 1}
g[] = {2, 2, 2}
b[] = {3, 3, 3}
Output: 4
Explanation: We can color the houses 
in RGR manner to incur minimum cost.
We could have obtained a cost of 3 if 
we coloured all houses red, but we 
cannot color adjacent houses with 
the same color.



Example 2:
Input:
N = 3
r[] = {2, 1, 3}
g[] = {3, 2, 1}
b[] = {1, 3, 2} 
Output: 3
Explanation: We can color the houses
in BRG manner to incur minimum cost.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function distinctColoring() which takes the size N and the color arrays r[], g[], b[] as input parameters and returns the minimum cost of coloring such that the color of no two houses is same.
*/
public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int N = 3;
        int r[] = {1, 1, 1};
        int g[] = {2, 2, 2};
        int b[] = {3, 3, 3};
        System.out.println("Number of Houses: " + N);
        System.out.println("Red Costs: " + Arrays.toString(r));
        System.out.println("Green Costs: " + Arrays.toString(g));
        System.out.println("Blue Costs: " + Arrays.toString(b));
        long result = distinctColoring(N, r, g, b);
        System.out.println("Minimum Cost to Paint Houses: " + result);
        sc.close();
    }
    public static long distinctColoring(int N, int[] r, int[] g, int[] b) {
        // code here
        long dp[][] = new long[N+1][3];
        // 0 -> red, 1 -> green, 2 -> blue
        for(int i=1;i<=N;i++){
            int ind = i-1; // 1 based index
            // Include current red + (min of previous blue or green)
            dp[i][0] = r[ind] + Math.min(dp[i-1][1], dp[i-1][2]);
            // Include current green + (min of previous blue or red)
            dp[i][1] = g[ind] + Math.min(dp[i-1][0], dp[i-1][2]);
            // Include current blue + (min of previous red or green)
            dp[i][2] = b[ind] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
    }
}


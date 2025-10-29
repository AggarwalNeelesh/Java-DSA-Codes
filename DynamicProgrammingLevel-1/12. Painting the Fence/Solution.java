import java.util.*;
/*
Painting the Fence
Difficulty: MediumAccuracy: 32.89%Submissions: 123K+Points: 4Average Time: 40m
Given a fence with n posts and k colours, find out the number of ways of painting the fence so that not more than two consecutive posts have the same colours.
Answers are guaranteed to be fit into a 32 bit integer.

Input: n = 3, k = 2 
Output: 6
Explanation: Let the 2 colours be 'R' and 'B'. We have following possible combinations:
1. RRB
2. RBR
3. RBB
4. BRR
5. BRB
6. BBR
Input: n = 2, k = 4 
Output: 16
Explanation: After coloring first post with 4 possible combinations, you can still color next posts with all 4 colors. Total possible combinations will be 4x4=16

colors = 3 houses = 4
        1           2                               3   
ii      0           3(rr, gg, bb)                   6(rgg, rbb, grr, gbb, brr, bgg)
ij      3(r,g,b)    3x2=6 (rg,rb,gr,gb,br,bg)       9x2=18 (rrg, rrb, ggr, ggb, bbr, bbg,__ rgr, rgb, rbr,rbg, grb,grg, gbr, gbg, brb, brg, bgb, bgr)
total   3           9                               24

*/



public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int houses = 5, colors = 3;
        System.out.println("Houses: " + houses + " Colors: " + colors);
        Solution ob = new Solution();
        System.out.println(ob.countWays(houses, colors));
        sc.close();  
    }
    int countWays(int n, int k) {
        // code here.
        int dp[][] = new int[n][2];
        dp[0][1] = k;
        for(int i=1;i<n;i++){
            dp[i][0] = dp[i-1][1]; // same color as previous
            dp[i][1] = (dp[i-1][0] + dp[i-1][1])*(k-1); // different color than previous
        }
        return dp[n-1][0] + dp[n-1][1];
    }
}


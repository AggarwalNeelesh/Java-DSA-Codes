import java.util.*;
/*
Tiling Mx1 tiles in MxN plane
Example - 
3x1 tiles in 3x6 plane

0   1   2   3   4   5
|   -   -   -   -   -
|   -   -   -   -   -
|   -   -   -   -   -
1

0   1   2   3   4   5
|   |   -   -   -   -
|   |   -   -   -   -
|   |   -   -   -   -
1   1

0   1   2   3   4   5         012    3   4   5
|   |   |   -   -   -   OR    ---    -   -   -
|   |   |   -   -   -         ---    -   -   -
|   |   |   -   -   -         ---    -   -   -
1   1   2

1   1   2   3 (Index 2 + Index 0) -> ((i-1) + (i-3)) or (i-1) + (i-m)

1   1   2   3   4 (Index 3 + Index 1)

1   1   2   3   4   6 (Index 4 + Index 2)


*/

public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int m=3, n = 7;
        System.out.println("Number of ways to tile a "+ m + " x "+n+" floor using "+m+" x 1 tiles is : "+numberOfWays(m, n));
        sc.close();  
    }
    static int numberOfWays(int m, int n) {
        // code here
        if(n<m)return 1;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            if(i<m)dp[i] = 1;
            else if(i==m)dp[i] = 2;
            else dp[i] = dp[i-1] + dp[i-m];
        }
        return dp[n-1];
    }
}


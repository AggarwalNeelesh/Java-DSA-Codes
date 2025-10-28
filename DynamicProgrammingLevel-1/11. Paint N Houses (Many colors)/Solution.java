import java.util.*;
/*
Paint N Houses
Difficulty: MediumAccuracy: 51.33%Submissions: 28K+Points: 4
There is a row of N houses, each house can be painted with N colours. The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color. Find the minimum cost to paint all houses.

The cost of painting each house in red, blue or green colour is given in the array r[], g[] and b[] respectively.


Example 1:
Input:
House = 4, Color = 3
1 5 7 (House 1 costs for 3 colors)
5 8 4
3 2 9
1 2 4

Output: 8
Explanation: We can color the houses 
in RGR manner to incur minimum cost.
We could have obtained a cost of 3 if 
we coloured all houses red, but we 
cannot color adjacent houses with 
the same color.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function distinctColoring() which takes the size N and the color arrays r[], g[], b[] as input parameters and returns the minimum cost of coloring such that the color of no two houses is same.
*/
public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int houses = 4, colors = 3;
        int houseColors[][] = {
            {1, 5, 7},
            {5, 8, 4},
            {3, 2, 9},
            {1, 2, 4}
        };
        System.out.println("House Colors : ");
        for(int i=0;i<houses;i++){
            System.out.println(Arrays.toString(houseColors[i]));    
        }
        long ans = distinctColoring(houses, colors, houseColors);
        System.out.println("Minimum cost to paint houses is : "+ans);   

    }
    public static long distinctColoring(int houses, int colors, int houseColors[][]) {
        // code here
        long dp[][] = new long[houses][colors];
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        int c1 = -1, c2 = -1;
        for(int i=0;i<houses;i++){
            long newMin1 = Long.MAX_VALUE, newMin2 = Long.MAX_VALUE;
            for(int j=0;j<colors;j++){
                dp[i][j] = houseColors[i][j];

                if(i!=0){// Not the first house
                    if(c1 == j){ // The color j is same as previous house's min color
                        dp[i][j] += min2;   // So we chose second minimum color
                    }else{
                        dp[i][j] += min1;
                    }
                }

                // Update min1 and min2 for next house
                if(dp[i][j] < newMin1){
                    newMin2 = newMin1;
                    c2 = c1;
                    newMin1 = dp[i][j];
                    c1 = j;
                }else if(dp[i][j] < newMin2){
                    newMin2 = dp[i][j];
                    c2 = j;
                }
            }
            min1 = newMin1;
            min2 = newMin2;
        }
        return min1;
    }
}


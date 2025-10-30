import java.util.*;
/*
Ways To Tile A Floor
Difficulty: BasicAccuracy: 32.31%Submissions: 52K+Points: 1
Given a floor of dimensions 2 x n and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled. 
A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile. 
Input: n = 3
Output: 3
Explanation: We need 3 tiles to tile the boardof size  2 x 3. 
We can tile in following ways:
1) Place all 3 tiles vertically. 
2) Place first tile verticallyand remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally and remaining tiles vertically.
Input: n = 4
Output: 5
Explanation: For a 2 x 4 board, there are 5 ways
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining 2 horizontal.
4) First 2 horizontal, remaining2 vertical.
5) Corner 2 vertical, middle 2 horizontal.
Input: n = 2
Output: 2

Explanation:
n = 1 -> |                                                                   -> 1 way
n = 2 -> || or =                                                             -> 2 ways
n = 3 ->                                                                     -> 3 ways
    current tile - |   -> "|| + |" and "= + |" (Options of 2)
    current tile - "-" -> "| + ="              (Options of 1)
n = 4 ->                                                                     -> 5 ways
    current tile - |   -> "||| + |", "|= + |" and "=| + |"   (Options of 3)
    current tile - "-" -> "|| + =", "= + ="                  (Options of 2)


which is basically a Fibonacci series.
*/



public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 7;
        System.out.println("Number of ways to tile a 2 x "+n+" floor is : "+numberOfWays(n));
        sc.close();  
    }
    static int numberOfWays(int n) {
        // code here
        if(n<=3)return n;
        int a = 2, b = 3, c = a+b;
        n-=3;
        while(n-->0){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}


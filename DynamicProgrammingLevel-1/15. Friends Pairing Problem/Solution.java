import java.util.*;
/*
Friends Pairing Problem
Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.

Examples :

Input: n = 3
Output: 4
Explanation:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.
Input: n = 2
Output: 2
Explanation:
{1} , {2} : All single.
{1,2} : 1 and 2 are paired.
Input: n = 1
Output: 1


Solution Approach:
n = 1 -> {1}                                                                   -> 1 way
n = 2 -> {1}, {2} or {1,2}                                                     -> 2 ways
n = 3 ->                                                                       -> 4 ways
    If friend 3 is single -> {1},{2},{3}  or  {1,2},{3}
    If friend 3 wants to pair it can pair with either 1 or 2 -> {1,3}, {2} and {2,3}, {1}   

n = 4 ->                                                                       -> 8 ways
    If friend 4 is single -> [{1},{2},{3},{4}  or  {1,2},{3},{4} or {1,3},{2},{4} or {2,3},{1}] + {4}   
        (Options to pair 3 friends)
    If friend 4 wants to pair it can pair with either 1,2 or 3 -> {1,4},{2},{3} , {2,4},{1},{3} and {3,4},{1},{2}
        (Options to pair 4 with any one of the remaining 3 friends) * {Options to pair remaining friends - 2 friends}

Answer(4) = Answer(3) + 3 * Answer(2)
or
Answer(n) = Answer(n-1) + (n-1) * Answer(n-2)

*/

public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 5;
        System.out.println("Number of ways in which "+ n + " friends can remain single or can be paired up is : "+countFriendsPairings(n));
        sc.close();  
    }
    public static long countFriendsPairings(int n) {
        // code here
        if(n<=2)return n;
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1] + i*dp[i-2];
        }
        return dp[n-1];
    }
}


import java.util.*;

public class Solution{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int coins[] = {1, 2, 5};
        int sum = 5;
        System.out.println("Coins : "+Arrays.toString(coins) + " Sum : "+sum);
        int ways = count(coins, sum);
        System.out.println("Number of ways to make sum "+sum+" is : "+ways);
    }
}

import java.util.*;
/*
Given an integer N. Your task is to find the number of binary strings of length N having no consecutive 1s.
As the number can be large, return the answer modulo 10^9+7.

Example 1:

Input:
N = 3
Output:
5
Explanation:
All the binary strings of length 3 having
no consecutive 1s are "000", "001", "101",
"100" and "010".
Example 2:

Input: 
N = 2
Output:
3
Explanation: 
All the binary strings of length 2 having no 
consecutive 1s are "10", "00" and "01".
Your Task:
You dont need to read input or print anything. Complete the function countStrings() which takes the integer N as the input parameter, and returns the number of binary strings of length N with no consecutive 1s.
*/
public class CountBinaryStringWithoutConsecutiveZero{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int N = 3;
        System.out.println("N : "+N);
        CountBinaryStringWithoutConsecutiveZero obj = new CountBinaryStringWithoutConsecutiveZero();
        int result = obj.countStrings(N);
        System.out.println("Number of binary strings of length "+N+" having no consecutive 1s is : "+result);
    }
    public int countStrings(int N) {
        // Code here
        int zero = 1, one = 1;
        for(int i=1;i<N;i++){
            int newZero = zero + one;
            int newOne = zero;
            zero = newZero;
            one = newOne;
        }
        return one + zero;
    }
}

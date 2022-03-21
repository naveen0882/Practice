package binary;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        
        bits[0] = 0;
        
        for(int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        
        return bits;
    }

}

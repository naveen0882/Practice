package string;

/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/
public class PalindromeSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int countSubstrings(String S) {
        int len = S.length(), ans = 0;
        for (int i = 0; i < len; i++) {
            int j = i - 1, k = i;
            while (k < len - 1 && S.charAt(k) == S.charAt(k+1)) k++;
            ans += (k - j) * (k - j + 1) / 2;
            i = k++;
            while (j >= 0 && k < len && S.charAt(k++) == S.charAt(j--)) ans++;
        }
        return ans;
    }
	
	public int countSubstrings2(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            count+=expandAroundCenter(s,i,i);
            count+=expandAroundCenter(s,i,i+1);
        }
        return count;
    }
    
    private int expandAroundCenter(String s,int left,int right){
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }

}

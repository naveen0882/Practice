package string;

import java.util.*;

/*
Design an algorithm to encode a list of strings to a string. 
The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.
 */
public class EncodeAndDecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        int numOfStr = strs.size();
        List<Integer> lengths = new LinkedList<Integer>();
        for (String s:strs) {
            lengths.add(s.length());
        }
        String result = numOfStr + "";
        for (Integer i:lengths) {
            result +=":" + i;
        }
        result += ":";
        for (String s:strs) {
            result +=s;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new LinkedList<String>();
        int i = 0;
        int numOfStr = 0;
        while (s.charAt(i) != ':') {
            numOfStr = numOfStr * 10 + (s.charAt(i) - '0');
            i ++;
        }
        List<Integer> lengths = new LinkedList<Integer>();
        i ++;
        for (int j = 0; j < numOfStr; j ++) {
            int leng = 0;
            while (s.charAt(i) != ':') {
                leng = leng * 10 + (s.charAt(i) - '0');
                i ++;
            }
            lengths.add(leng);
            i ++;
        }
        for (Integer l:lengths) {
            String tmp = "";
            for (int j = 0; j < l; j ++) {
                tmp +=s.charAt(i);
                i ++;
            }
            result.add(tmp);
        }
        return result;
    }

}

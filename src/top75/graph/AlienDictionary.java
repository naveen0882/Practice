package graph;

import java.util.*;

/*
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographically in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the 
blank character which is less than any other character (More info).

*/
public class AlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            m.put(order.charAt(i), i);
        }
        
        for(int i = 1; i < words.length; i++){
            int j = 0;
            while(j < Math.min(words[i].length(), words[i-1].length())){
            if(m.get(words[i].charAt(j)) < m.get(words[i-1].charAt(j))){
                return false;
            }
                
            else if(m.get(words[i].charAt(j)) == m.get(words[i-1].charAt(j))){
                j++;
            }
                else{
                    break;
                }
                
                  
            }
            if(j == words[i].length() && words[i].length() < words[i-1].length()){
                return false;
            }
            
        }
        return true;
    }
	
	public boolean isAlienSorted2(String[] words, String order) {        
        int prioirty = order.length();
        Map<Character, Integer> orderMap = new HashMap();
        for(char c : order.toCharArray()) orderMap.put(c, prioirty--); //high priority to low priority
        
        int first = 0;
        for(int second = 1 ; second < words.length; first++, second++)
            if(!checkTwoStringOrder(words[first].toCharArray(), words[second].toCharArray(), orderMap))
                return false;
        
        return true;
    }
    
    public boolean checkTwoStringOrder(char[] first, char[] second, Map<Character, Integer> orderMap) {        
        for(int it1 = 0, it2=0 ;it1 < first.length && it2 < second.length; it1++, it2++){
            if(orderMap.get(first[it1]) > orderMap.get(second[it2]))
                return true;
            else if(orderMap.get(first[it1]) < orderMap.get(second[it2]))
                return false;
        }
        if(first.length == second.length) // if the words has same length then we are okay.
            return true;
        else
            return first.length < second.length ? true : false; //first must not be long from second
    }

}

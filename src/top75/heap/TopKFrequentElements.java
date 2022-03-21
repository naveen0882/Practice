package heap;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]
*/
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        PriorityQueue<Integer> heap = 
            new PriorityQueue<>(k, Comparator.comparingInt(i -> counts.get(i) * -1));
        
        for(int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        for(int key: counts.keySet()) {
            heap.add(key);
        }
        
        int[] result = new int[k];
        
        for(int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        
        return result;
    }
	
	public int[] topKFrequent2(int[] nums, int k) {
		//create array of lists to be used as buckets
		//we need to sort by frequency 
		//NOTE: if we know frequencies are unique we can use simple int[]
		//but since we can have duplicated frequencies we need a way to store all duplicates 
		//thats why we use List<Integer>[] instead of simple int[]
		List<Integer>[] freqSorted = new List[nums.length +1];
		Map<Integer, Integer> frequencyMap = new HashMap();
		List<Integer> res = new ArrayList();

		//find how often each char occured
		for(int n: nums)
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

	   //iterate thru frequency map and add to freqSorted key at position frequency
	   //NOTE: each index of freqSorted represents frequency 
	  //Example: at position freqSorted[3] we will store all elements that appeared 3 times
	   for(int key: frequencyMap.keySet()){
		   if(freqSorted[frequencyMap.get(key)] == null)
			   freqSorted[frequencyMap.get(key)] = new ArrayList();
		   freqSorted[frequencyMap.get(key)].add(key);
	   }

	   //iterate again starting from right to left 
	   //since we need most frequent  
	   //NOTE: if problem asks for least frequent nums iterate from left to right 
	   for(int i = freqSorted.length - 1; i >= 0 && res.size() < k; i--)
		   if(freqSorted[i] != null){
				res.addAll(freqSorted[i]);
	  }

	  return res.stream().mapToInt(i->i).toArray();
	}

}

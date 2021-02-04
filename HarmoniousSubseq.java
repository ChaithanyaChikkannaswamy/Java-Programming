/*
* Date: Feb 4th 2021
* Question: https://leetcode.com/problems/longest-harmonious-subsequence/
*/

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int elem : nums){
            int curfreq = map.getOrDefault(elem, 0);
            map.put(elem, (curfreq+1) );
        }
        
        int maxHS = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int curKey = entry.getKey();
            int freq = entry.getValue();
            int curHS = 0;
            
            if(map.containsKey(curKey+1)){
                curHS  = freq + map.get(curKey+1);
            }
            maxHS = Math.max(maxHS, curHS);
        }
        return maxHS;
        
    }
    
}

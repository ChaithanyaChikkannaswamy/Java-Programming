/*
* Question: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/submissions/
* Date: 06/06/2021
*/

// Solution1 - Using HashMap

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : time){
            if( t % 60 == 0)
                count += map.getOrDefault(0,0);
            else
                count += map.getOrDefault(60 - t %60, 0);
            
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return count;
        
    }
}

// TC: O(n)


//Solution2 - Using Arrays

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] map = new int[60];
        for(int t : time){
            if( t % 60 == 0)
                count += map[0];
            else
                count += map[60 - t %60];
            
            map[t % 60]++;
        }
        return count;
        
    }
}

// TC: O(n)

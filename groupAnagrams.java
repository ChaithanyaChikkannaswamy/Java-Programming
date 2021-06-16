/*
Question: https://leetcode.com/problems/group-anagrams/
Date: 06/16/2021
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       //create list and map to store the result and the sorted strings
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str:strs){
            //concert str to array, sort the array and convert it back to string
            char []chararr = str.toCharArray();
            Arrays.sort(chararr);
            String sortedstr = new String(chararr);
            
            //check if it exists in map, if not, add the str to map
            if(map.containsKey(sortedstr))
                map.get(sortedstr).add(str);
            
            //else create a new list, add the sorted str to the list and the respective str to map
            else{
                List<String> tempList = new ArrayList<>();
                result.add(tempList);
                tempList.add(str);
                map.put(sortedstr, tempList);
            }
        }
        
        return result;       
    }
}



/*
1.loop through each str in the arry
2.sort the string
3.insert it to the hashmap
4.iterate through the hashmap and add each str value to result array
5. return the result


Time Complexity: O(n*klogk)
Space Cpmplexity: O(n)
*/

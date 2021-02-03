/*
* Date: 02/03/2021
* Question: https://leetcode.com/problems/linked-list-cycle/
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hash_Set = new HashSet<ListNode>();
        ListNode listhead = head;
        if(listhead == null)
            return false;
        while(listhead!= null){
            if(hash_Set.contains(listhead))
                return true;
        
        hash_Set.add(listhead);
        listhead = listhead.next;
    }
        return false;
    }
}

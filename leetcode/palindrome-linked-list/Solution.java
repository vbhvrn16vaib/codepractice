/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    boolean ans = true;
    // ListNode tmp;
    public boolean isPalindrome(ListNode head) {
        // tmp = head;
        dfs(head, head);
        return ans;
    }
    ListNode dfs(ListNode h1, ListNode h2){
        if(h1.next == null){
            ans = ans && h2.val == h1.val;
            return h2.next;
        }
        ListNode t = dfs(h1.next, h2);
        ans = ans && h1.val == t.val;
        return t.next;
    }
    // boolean dfs(ListNode h1){
    //     if(h1 == null){
    //         return true;
    //     }   
    //     boolean ans = h1.val == tmp.val &&  dfs(h1.next);
    //     tmp = tmp.next;
    //     return ans;
    // }
}
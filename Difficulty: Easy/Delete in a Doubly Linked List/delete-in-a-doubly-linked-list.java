/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
// class Solution {
//     public Node deleteNode(Node head, int x) {
//         // code here
//         Node temp = head;
//         while(temp != null){
//             if(temp.data == x){
//                 temp.next.prev = temp.prev;
//                 temp.prev.next = temp.next;
//                 return head;
//             }
//             temp = temp.next;
//         }
//         return head;
//     }
// }

class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if (x == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        Node temp = head;
        while(x != 1){
            x--;
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        return head;
    }
}
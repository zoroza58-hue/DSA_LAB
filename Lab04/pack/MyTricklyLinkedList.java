package pack;

public class MyTricklyLinkedList extends MyLinkedList {
    public void q1_rotate_counter_clockwise(int k) {
        if (head == null || size <= 1) {
            return;
        }

        Node tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        // tailNode.next = head;

        Node cutKNode = head;
        for (int i = 1; i < k; i++) {
            cutKNode = cutKNode.next;
        }
        cutKNode.next = null;
        tailNode.next = head;
        head = tailNode;
        
    }

    public void q2_reverse() {

    }

    public void q3_remove_dup() {

    }

    public void q4_increment_digits() {

    }

    public boolean q5_isPalindrome() {
        return false;
    }
}

package pack;

public class MyTricklyLinkedList extends MyLinkedList {
    public void q1_rotate_counter_clockwise(int k) {
        if (head == null || k == 0) {
            return;
        }
        k = k % size();
        if (k == 0) {
            return;
        }
        
        Node tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        tailNode.next = head;

        Node current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        } 
        head = current.next;
        current.next = null;
    }

    public void q2_reverse() {
        if (head == null) { return;}

        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void q3_remove_dup() {

    }

    public void q4_increment_digits() {

    }

    public boolean q5_isPalindrome() {
        return false;
    }
}

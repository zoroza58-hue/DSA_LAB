package pack;

public class MyTricklyLinkedList extends MyLinkedList {
    public void q1_rotate_counter_clockwise(int k) {
        if (head == null || size <= 1 || k == 0) return;

        int size = size();
        k %= size;
        Node tail = head;
        while (tail.next != null) { tail = tail.next; }
        tail.next = head;

        Node cutNode = head;
        for (int i = 1; i < k; i++) {
            cutNode = cutNode.next;
        }
        cutNode.next = null;

        head = tail;
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

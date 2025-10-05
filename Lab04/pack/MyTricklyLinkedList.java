package pack;

public class MyTricklyLinkedList extends MyLinkedList_650909 {
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
        if (head == null) { return; }

        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public void q4_increment_digits() {
        if (head == null) { return; }

        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data < 9) {
                current.data += 1;
            } else {
                current.data = 0;
                count++;
            }
            current = current.next;
        }
        if (count == size()) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
    }

    public boolean q5_isPalindrome() {
        if (head == null || head.next == null) { return false; }

        Node front = head;
        Node half = head;
        int len = size();

        for (int i = 0; i < len/2; i++) {
            half = half.next;
        }
        if (len % 2 != 0) {
            half = half.next;
        }

        MyTricklyLinkedList back = new MyTricklyLinkedList();
        while (half != null) {
            back.add(half.data);
            half = half.next;
        }

        while (front != null && back.head != null) {
            if (front.data != back.head.data) {
                return false;
            }
            front = front.next;
            back.head = back.head.next;
        }
        return true;
    }
}

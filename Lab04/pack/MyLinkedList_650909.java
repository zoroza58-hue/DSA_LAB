package pack;

public class MyLinkedList_650909 {
    class Node {
        protected int data;
        protected Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }
    protected Node head = null;
    protected int size = 0;

    public int size() { return size; }

    public void add(int d) {
        Node p = new Node(d);
        if (head == null) {
            head = p;
            size++;
            return;
        }

        p.next = head;
        head = p;
        size++;
    }

    public void add(int [] data) {
        for (int d : data) {add(d);} 
    }

    public void insert(int d) {
        Node newNode = new Node(d);

        if (head == null || head.data >= d) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node p = head;
        while (p.next != null && p.next.data < d) {
            p = p.next;
        }

        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    public void insert(int [] data) {
        for (int d : data) { insert(d); }
    }

    public int find(int d) {
        Node p = head;
        int i = 0;

        while (p != null) {
            if (p.data == d) {
                return i;
            }
            p = p.next;
            i++;
        }
        return -1;
    }

    public void delete(int d) {
        if (head == null) { return; }

        Node temp = new Node(0);
        temp.next = head;
        Node p = temp;

        while (p.next != null && p.next.data != d) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
            size--;
        }

        head = temp.next;
    }

    public void setAt(int index) {
        
    }

    public void getAt(int index) {

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("head");
        Node p = head;
        while (p != null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("]");
            p = p.next;
        }
        sb.append("--> null");
        return new String(sb);
    }
}
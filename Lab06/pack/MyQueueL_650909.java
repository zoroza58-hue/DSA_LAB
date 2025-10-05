package Lab06.pack;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class MyQueueL_650909<T> implements Iterable<T> { 
    private List<T> items = new LinkedList<>();
    
    public void enqueue(T item) {
        items.add(item);
    }

    public T dequeue() {
        if (items.isEmpty()) {
            return null;
        }
        return items.remove(0); 
    }

    public T peek() {
        if (items.isEmpty()) {
            return null;
        }
        return items.get(0);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top->");
        for (T item : items) {
            sb.append(item).append("->");
        }
        sb.append("bottom");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
}

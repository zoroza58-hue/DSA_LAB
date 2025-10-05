package Lab06;

import java.util.Iterator;

import Lab06.pack.MyQueueL_650909;
import Lab06.pack.MyShuntingYard;
import Lab06.pack.MyRPN;

public class Lab06_650909 {
    static void task_2() {
        MyQueueL_650909<String> queue = new MyQueueL_650909<>();
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cantaloupe");
        System.out.println("standard for each: ");
        for (var item : queue) {
            System.out.println(item + " ");
        }
        System.out.println();
        System.out.println("demo iterator");
        Iterator<String> iter = queue.iterator();
        char ch = 'n';
        while (iter.hasNext()) {
            String item = iter.next();
            if (item.indexOf(ch) != -1) {
                System.out.println(item + " ");
            }
        }
        System.out.println();
    }

    static void task_3() { // compute InFix
        String inFix = "( 4 + 2 ) / 3 * ( 8 - 5 )";
        String postFix = MyShuntingYard.infixToPostfix(inFix);
        System.out.println("postFix= " + postFix);
        double ans = MyRPN.computeRPN(postFix);
        System.out.println(ans); 
    }

    public static void main(String[] args) {
        // task_2();
        task_3();
    }
}

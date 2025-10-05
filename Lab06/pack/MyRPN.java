package Lab06.pack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyRPN {
    public static double computeRPN(String postfix) {
        if (postfix == null || postfix.isBlank()) {
            return 0.0;
        }

        Deque<Double> stack = new ArrayDeque<>();

        for (String token : postfix.trim().split("\\s+")) {
            if (token.isEmpty()) {
                continue;
            }

            switch (token) {
                case "+":
                    requireOperands(stack, 2);
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    requireOperands(stack, 2);
                    double subtrahend = stack.pop();
                    stack.push(stack.pop() - subtrahend);
                    break;
                case "*":
                    requireOperands(stack, 2);
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    requireOperands(stack, 2);
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid postfix expression");
        }

        return stack.pop();
    }

    private static void requireOperands(Deque<Double> stack, int count) {
        if (stack.size() < count) {
            throw new IllegalStateException("Insufficient operands for operator");
        }
    }
}

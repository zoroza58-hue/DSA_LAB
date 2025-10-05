package Lab06.pack;

import java.util.Stack;

public class MyShuntingYard {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public static String infixToPostfix(String infix) {
        if (infix == null || infix.isBlank()) {
            return "";
        }

        Stack<String> operatorStack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (String token : infix.trim().split("\\s+")) {
            if (token.isEmpty()) {
                continue;
            }

            switch (token) {
                case "(":
                    operatorStack.push(token);
                    break;
                case ")":
                    while (!operatorStack.isEmpty() && !"(".equals(operatorStack.peek())) {
                        appendToken(output, operatorStack.pop());
                    }
                    if (!operatorStack.isEmpty() && "(".equals(operatorStack.peek())) {
                        operatorStack.pop();
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!operatorStack.isEmpty()
                            && !"(".equals(operatorStack.peek())
                            && order(operatorStack.peek()) >= order(token)) {
                        appendToken(output, operatorStack.pop());
                    }
                    operatorStack.push(token);
                    break;
                default:
                    appendToken(output, token);
                    break;
            }
        }

        while (!operatorStack.isEmpty()) {
            String op = operatorStack.pop();
            if (!"(".equals(op) && !")".equals(op)) {
                appendToken(output, op);
            }
        }

        return output.toString();
    }

    private static void appendToken(StringBuilder output, String token) {
        if (output.length() > 0) {
            output.append(' ');
        }
        output.append(token);
    }
}

// package Day-5(monday);
import java.util.Stack;

public class prefixpostfix {
     static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }

    // Method to check if a character is operand
    static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    // Method to convert infix to postfix
    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (isOperand(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // remove '('
            } else { // operator
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators from stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Method to evaluate postfix expression
    static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // convert char digit to int
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;

                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    case '^':
                        result = (int) Math.pow(operand1, operand2);
                        break;
                }

                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = scanner.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);

        int result = evaluatePostfix(postfix);
        System.out.println("Evaluated Result: " + result);
    }
    
}

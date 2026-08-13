// package Day-5(monday);

import java.util.Stack;

public class practise {

    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();


        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']')) {
                    return false;
                }
                
            }
        }

        return stack.isEmpty();
    }




    public static void main(String[] args) {
        String expression = "[{()}]";
        System.out.println("Input: " + expression);
        System.out.println("Valid Parentheses: " + isValidParentheses(expression));

        String expression2 = "([)]";
        System.out.println("Input: " + expression2);
        System.out.println("Valid Parentheses: " + isValidParentheses(expression2));
    }
}

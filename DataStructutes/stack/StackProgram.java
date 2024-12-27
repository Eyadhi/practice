package stack;

import java.util.Stack;

public class StackProgram {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                s1.push(ch);
            } else if (!s1.empty() && ((ch == ')' && s1.peek() == '(') || (ch == '}' && s1.peek() == '{')
                    || (ch == ']' && s1.peek() == '['))) {
                s1.pop();
            } else {
                s1.push(ch);
            }
        }
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        StackProgram s1 = new StackProgram();
        System.out.println(s1.isValid("(())["));
    }
}

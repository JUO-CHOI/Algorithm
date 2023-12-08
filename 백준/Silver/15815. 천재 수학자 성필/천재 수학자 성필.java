import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.push(Character.getNumericValue(s.charAt(i)));
            }
            else {
                stack.push(cal(stack.pop(), stack.pop(), s.charAt(i)));
            }
        }
        System.out.println(stack.peek());
    }

    public static int cal(int b, int a, char op) {
        switch (op) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
            case '/' :
                return a / b;
        }
        return 0;
    }
}

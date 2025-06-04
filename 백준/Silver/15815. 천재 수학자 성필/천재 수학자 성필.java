import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                stack.push(Integer.parseInt(input.substring(i, i + 1)));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                char op = input.charAt(i);
                switch (op) {
                    case ('+') :
                        stack.push(a + b);
                        break;
                    case ('-') :
                        stack.push(a - b);
                        break;
                    case ('*') :
                        stack.push(a * b);
                        break;
                    case ('/') :
                        stack.push(a / b);
                        break;
                }
            }
        }

        System.out.print(stack.pop());
    }
}

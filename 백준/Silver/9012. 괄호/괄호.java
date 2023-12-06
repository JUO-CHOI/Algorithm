import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            check(s);
        }
    }

    // check 메소드 만들기
    public static void check(String s) {
        // 괄호를 넣을 스택 만들기
        Stack<Character> checkStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                checkStack.push(s.charAt(i));
            else {
                if (checkStack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                checkStack.pop();
            }
        }
        if (checkStack.isEmpty())
            System.out.println("YES");
        else System.out.println("NO");
    }
}

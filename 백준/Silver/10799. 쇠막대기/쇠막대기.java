import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int answer = 0;

        // 처음 시작은 무조건 ( 이겠지?
        Stack<Character> stack = new Stack<>();
        stack.push('(');

        for (int i = 1; i < input.length(); i++) {
            char c =input.charAt(i);
            // 시작점이면 일단 넣고보기
            if (c == '(') {
                stack.push(c);
            }
            // 끝지점이면 절단기인지 끝인지 확인하기
            if (c == ')') {
                // 절단기
                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                }
                // 끝지점
                else {
                    stack.pop();
                    answer += 1;
                }
            }
        }

        System.out.print(answer);
    }
}

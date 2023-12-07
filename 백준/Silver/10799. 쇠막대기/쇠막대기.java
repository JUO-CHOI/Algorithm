import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') { // (
                stack.push(c);
            }
            else { // )
                if (line.charAt(i - 1) == '(') { // ()이므로 레이저
                    // 이전에 있던 막대기가 잘린것 -> 스택 사이즈만큼 더해준다.
                    stack.pop(); // 레이저쌍 pop
                    answer += stack.size();
                }
                else { // )) 이므로 막대기 끝을 의미 -> 앞에 쌍 하나 pop하고 한조각 더함
                    stack.pop(); // 막대기쌍 pop
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }

}

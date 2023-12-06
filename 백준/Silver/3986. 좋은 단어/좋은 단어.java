import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            answer += check(s);
        }
        System.out.println(answer);
    }

    public static int check(String s) {
        Stack<Character> stack = new Stack<>();

        // 첫글자 넣고 시작
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // 비어있으면 넣고
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            // 같은거 들어오면 삭제
            if (stack.peek() == s.charAt(i))
                stack.pop();
            // 앞에거랑 달라도 넣을 순 있음 -> 짝이 들어오면 위 if에서 삭제
            else
                stack.push(s.charAt(i));
        }
        // 결국 나중에 다 했을때 안비어있으면 나쁜 단어
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}

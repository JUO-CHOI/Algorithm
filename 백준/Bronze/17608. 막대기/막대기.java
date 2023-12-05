import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // N 받기
        int n = Integer.parseInt(reader.readLine());
        // N개의 정수 받기
        int[] sticks = new int[n];
        Stack<Integer> stickStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int stickLength = Integer.parseInt(reader.readLine());
            stickStack.push(stickLength);
        }
        System.out.println(visibleStick(stickStack));
    }

    public static int visibleStick(Stack<Integer> stack) {
        int count = 0;
        int height = 0;
        while (!stack.empty()) {
            if (stack.peek() > height) {
                height = stack.pop();
                count++;
            }
            else stack.pop();
        }
        return count;
    }
}
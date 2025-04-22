import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // N 입력받기
        int n = Integer.parseInt(reader.readLine());
        // N개의 배열 만들기
        int[] sticks = new int[n];

        // 막대기 입력받기
        for (int i = 0; i < n; i++) {
            sticks[i] = Integer.parseInt(reader.readLine());
        }

        int answer = 0;
        int max = 0;

        // 오른쪽부터 검사하기
        // 그동안 나왔던 막대보다 더 긴 막대만 보임
        for (int i = 0; i < n; i++) {
            if (sticks[n - i - 1] > max) {
                max = sticks[n - i - 1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}

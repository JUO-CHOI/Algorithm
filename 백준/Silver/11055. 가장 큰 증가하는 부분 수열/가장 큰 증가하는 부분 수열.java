import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int[] sequence = new int[n]; // 수열을 담을 배열
        int[] dp = new int[n]; // dp[i]는 i번째 수가 가장 큰 부분 수열의 합 (증가하기 때문에)
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // dp 채우기
        for (int i = 0; i < n; i++) {
            dp[i] = sequence[i]; // 최소 합은 본인
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
                }
            }
        }

        // 가장 큰 값 찾기
        int answer = 0;
        for (int num : dp) {
            if (num > answer) {
                answer = num;
            }
        }
        System.out.println(answer);
    }
}

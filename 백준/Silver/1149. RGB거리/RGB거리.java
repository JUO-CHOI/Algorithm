import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[][] cost = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] inputCost = reader.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(inputCost[j]);
            }
        }

        int[][] dp = new int[n][3];

        // 첫 가격 채우기
        for (int i = 0; i < 3; i++) {
            dp[0][i] = cost[0][i];
        }

        // dp 채우기
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]; // 현재 집을 빨간색으로
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]; // 현재 집을 초록색으로
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]; // 현재 집을 파란색으로
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (dp[n - 1][i] < answer) {
                answer = dp[n - 1][i];
            }
        }

        System.out.print(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] points = new int[n + 1];
        points[0] = 0;
        for (int i = 1; i <= n; i++) {
            points[i] = Integer.parseInt(reader.readLine());
        }

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = points[1];
        if (n >= 2) {
            dp[2] = dp[1] + points[2];
        }

        for (int i = 3; i <= n; i++) {
            // 한계단 오른 점수와 두계단 오른 점수 중 큰 값
            // 한계단을 올랐다는건 전에는 두계단을 오른 것
            dp[i] = Integer.max(dp[i - 3] + points[i - 1] + points[i], dp[i -2] + points[i]);
        }

        System.out.println(dp[n]);
    }
}

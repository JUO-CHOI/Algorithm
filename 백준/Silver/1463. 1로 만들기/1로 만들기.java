import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0 || i % 2 == 0) {
                if (i % 3 == 0 && i % 2 == 0) {
                    dp[i] = Math.min(Math.min(dp[i / 3] + 1, dp[i / 2] + 1), dp[i]);
                }
                else if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
                }
                else {
                    dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}

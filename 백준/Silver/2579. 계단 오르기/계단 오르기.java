import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        int[] dp = new int[n + 1];

        dp[1] = stairs[1];
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= n; i++) {
            // 2계단 건넌 경우 or
            // 한계단 건넌 경우(이땐 앞에서 연속이 아니어야 하므로 dp[i - 3]에서 두계단 건너 i - 1을 더하고 i를 더함)
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        System.out.println(dp[n]);
    }
}
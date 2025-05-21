import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] inputSequence = reader.readLine().split(" ");
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] =Integer.parseInt(inputSequence[i]);
        }

        int[] dp = Arrays.copyOf(sequence, sequence.length);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}

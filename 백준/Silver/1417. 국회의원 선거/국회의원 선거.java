import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine()); // 국회의원 n명

        int[] votes = new int[n];

        for (int i = 0; i < n; i++) {
            votes[i] = Integer.parseInt(reader.readLine());
        }


        int count = 0;

        while (true) {
            int maxIndex = 0;
            int maxVotes = 0;

            for (int i = 0; i < n; i++) {
                if (votes[i] >= maxVotes) {
                    maxIndex = i;
                    maxVotes = votes[i];
                }
            }

            if (maxIndex == 0) break;

            votes[0]++;
            votes[maxIndex]--;
            count++;
        }

        System.out.print(count);
    }
}

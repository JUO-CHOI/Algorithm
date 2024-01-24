import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine()); // n
        int answer = -1;
        int max = n / 5;

        for (int i = 0; i <= max + 1; i++) {
            if (n % 3 == 0) {
                answer = i + (n / 3);
            }
            n -= 5;
            if (n < 0) break;
        }

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int answer = 0;
        int maxIndex = 0;

        while (true) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] >= max) {
                    maxIndex = i;
                    max = arr[i];
                }

            }
            if (maxIndex == 0) break;
            arr[0]++;
            arr[maxIndex]--;
//            System.out.println(arr[0] + " " + maxIndex + " " + arr[maxIndex]);
            answer++;
        }

        System.out.println(answer);
    }
}

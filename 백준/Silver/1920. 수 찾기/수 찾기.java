import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] input = reader.readLine().split(" ");

        int m = Integer.parseInt(reader.readLine());

        String[] targets = reader.readLine().split(" ");

        Arrays.sort(input);

        int[] answer = new int[m];
        Arrays.fill(answer, 0);

        for (int i = 0; i < m; i++) {
            String target = targets[i];
//            for (int j = 0; j < n; j++) {
//                if (target.equals(input[j])) {
//                    answer[i] = 1;
//                    break;
//                }
//            }
            int a = Arrays.binarySearch(input, target);
            if (a >= 0) {
                answer[i] = 1;
            }
        }

        for (int num : answer) {
            System.out.println(num);
        }
    }
}
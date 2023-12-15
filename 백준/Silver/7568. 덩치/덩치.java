import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<int[]> input = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            input.add(new int[]{Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1])});
        }

        int[] ranks = new int[n];
        Arrays.fill(ranks, 1);

        // 자신보다 큰게 몇개있나 확인해보자
        for (int i = 0; i < n - 1; i++) {
            int[] arr = input.get(i);
            for (int j = i + 1; j < n; j++) {
                int[] compare = input.get(j);
                // 1. 나보다 큰 경우
                if (arr[0] < compare[0] && arr[1] < compare[1]) {
                    ranks[i]++;
                }
                // 2. 내가 더 큰 경우
                else if (arr[0] > compare[0] && arr[1] > compare[1]) {
                    ranks[j]++;
                }
                // 3. 비교할 수 없는 경우
               // 내 앞에 있다고 할 수 없으니 넘어감
            }
        }

        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}

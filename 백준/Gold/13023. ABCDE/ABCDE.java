import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

    static boolean[] used;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<List<Integer>> list = new ArrayList<>();
        used = new boolean[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            list.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
            list.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 1, list);
            // 찾았으니까 그냥 break
            if (answer == 1) break;
            Arrays.fill(used, false);
        }

        System.out.println(answer);

    }

    public static void dfs(int node, int depth, List<List<Integer>> list) {
        used[node] = true;
        if (depth == 5) {
            answer = 1;
            return;
        }
        // 답 이미 찾았으면 멈춤
        if (answer == 0) {
            for (int neighbor : list.get(node)) {
                if (!used[neighbor]) {
                    dfs(neighbor, depth + 1, list);
                    used[neighbor] = false;
                }
            }
        }
    }
}

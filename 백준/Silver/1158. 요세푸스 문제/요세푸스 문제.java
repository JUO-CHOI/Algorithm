import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int[] answer = new int[n];

        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++) {
                tmp = queue.poll(); // 큐가 비어있으면 런타임에러가 발생할 수 있으나 크기가 n인 큐에서 한개씩 n번 빼내는거라 비어있을 수 없음
                queue.offer(tmp);
            }
            answer[i] = queue.poll();
        }

        System.out.print("<");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(answer[i] + ", ");
        }
        System.out.print(answer[n - 1] + ">");
    }
}
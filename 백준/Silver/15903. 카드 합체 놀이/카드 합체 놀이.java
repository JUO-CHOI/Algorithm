import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // 최종 합이 가장 작으려면 최대한 작은 수끼리 더해야 함
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        String[] cards = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Long.parseLong(cards[i]));
        }

        for (int i = 0; i < m; i++) {
            // 맨 앞에 두 카드 빼서 더한 다음 그 값을 두번 넣어줌 (두 카드에 값 덮어쓰기)
            long num1 = priorityQueue.poll();
            long num2 = priorityQueue.poll();
            priorityQueue.add(num1 + num2);
            priorityQueue.add(num1 + num2);
        }

        long answer = 0;
        while (!priorityQueue.isEmpty()) {
            answer += priorityQueue.poll();
        }
        System.out.println(answer);
    }
}

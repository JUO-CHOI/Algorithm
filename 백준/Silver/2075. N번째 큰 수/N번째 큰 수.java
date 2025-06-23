import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                priorityQueue.offer(Integer.parseInt(input[j]));
            }
        }

        int size = priorityQueue.size();

        for (int i = 0; i < size; i++) {
            int num = priorityQueue.poll();
            if (i < n - 1) continue;
            System.out.print(num);
            break;
        }
    }
}
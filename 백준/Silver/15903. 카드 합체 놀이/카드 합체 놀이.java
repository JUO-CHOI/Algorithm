import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputMN = reader.readLine().split(" ");
        String[] inputNums = reader.readLine().split(" ");

        int n = Integer.parseInt(inputMN[0]);
        int m = Integer.parseInt(inputMN[1]);

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputNums[i]);
        }

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.offer((long)nums[i]);
        }

        long temp1;
        long temp2;
        for (int i = 0; i < m; i++) {
            temp1 = priorityQueue.poll();
            temp2 = priorityQueue.poll();

            for (int j = 0; j < 2; j++) {
                priorityQueue.offer(temp1 + temp2);
            }
        }

        long sum = 0;
        while (!priorityQueue.isEmpty()) {
            sum += priorityQueue.poll();
        }

        System.out.println(sum);
    }
}

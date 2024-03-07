import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                priorityQueue.add(Integer.parseInt(line[j]));
            }
        }

        int index = 1;
        while (true) {
            if (index == n) {
                System.out.print(priorityQueue.poll());
                break;
            }
            else {
                priorityQueue.poll();
            }
            index++;
        }
    }
}

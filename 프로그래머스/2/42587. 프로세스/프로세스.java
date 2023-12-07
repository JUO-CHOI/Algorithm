import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Process> process = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            process.add(new Process(i, priorities[i]));
        }

        Arrays.sort(priorities);
        int idx = priorities.length - 1;

        while (!process.isEmpty()) {
            if (process.peek().getPriority() == priorities[idx]) {
                if (process.peek().getNum() == location) {
                    answer++;
                    break;
                }
                process.poll();
                answer++;
                idx--;
            }
            else {
                process.add(process.poll());
            }
        }
        return answer;
    }
}

class Process {
    private int num;
    private int priority;

    public Process(int num, int priority) {
        this.num = num;
        this.priority = priority;
    }

    public int getNum() {
        return num;
    }
    public int getPriority() {
        return priority;
    }
}

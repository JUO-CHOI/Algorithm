import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1Q = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cards2Q = new LinkedList<>(Arrays.asList(cards2));

        for (int i = 0; i < goal.length; i++) {
            if (!cards1Q.isEmpty() && cards1Q.peek().equals(goal[i])) {
                cards1Q.poll();
            }
            else if (!cards2Q.isEmpty() && cards2Q.peek().equals(goal[i])) {
                cards2Q.poll();
            }
            else {
                return "No";
            }
        }
        return "Yes";
    }
}
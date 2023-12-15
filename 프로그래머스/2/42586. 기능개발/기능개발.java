import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        int index = 0;

        while (true) {
            int count = 0;
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            while (index < progresses.length && progresses[index] >= 100) {
                count++;
                index++;
            }
            if (count != 0) answerList.add(count);
            if (index == progresses.length) {
                break;
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
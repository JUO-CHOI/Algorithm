import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static Integer[] solution(int[] arr) {
        // 배열을 받아서
        // 연속하면 중복 삭제

        List<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);
        int listNum = 0;
        System.out.println(answerList.get(0));
        for (int i = 0; i < arr.length; i++) {
            if (answerList.get(listNum) == arr[i]) continue;
            answerList.add(arr[i]);
            listNum++;
        }

        return answerList.toArray(new Integer[0]);
    }
}
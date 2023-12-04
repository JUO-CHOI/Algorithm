import java.util.ArrayList;
import java.util.List;

class Solution {
public Object[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < intStrs.length; i++) {
            int intStr = Integer.parseInt(intStrs[i].substring(s, s + l));
            if(intStr > k) {
                answerList.add(intStr);
            }
        }
        return answerList.toArray();
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
public static int solution(int[] citations) {
        List<Integer> sortList = new ArrayList<>();
        for (int citatation : citations) {
            sortList.add(citatation);
        }
        Collections.sort(sortList, Collections.reverseOrder());

        int answer = 0;

        for (int i = 1; i <= sortList.size(); i++) {
            if (sortList.get(i - 1) >= i) {
                answer++;
            }
            else {
                break;
            }
        }
        return answer;
    }
}
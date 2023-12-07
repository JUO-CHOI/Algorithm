import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] solution(String[] names, int[] yearning, String[][] photos) {
        // 사람마다 점수를 매기는 맵을 만들자
        Map<String, Integer> yearningPoint = new HashMap<>();
        // names.length == yearning.length
        for (int i = 0; i < names.length; i++) {
            yearningPoint.put(names[i], yearning[i]);
        }

        // 점수 베열
        int[] sumArr = new int[photos.length];
        int i = 0;
        for (String[] photo : photos) { // 각 사진마다
            for (String name : photo) { // 각 사람마다
                if (yearningPoint.get(name) == null) // 사진에 있는 사람 중 그리워하지 않는 사람은 map에서 get 못함 -> 예외 발생
                    continue;
                sumArr[i] += yearningPoint.get(name); // 점수를 찾아서 더해주자
            }
            i++;
        }
        return sumArr;
    }
}
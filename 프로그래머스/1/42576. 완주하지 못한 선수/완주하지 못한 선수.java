import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> mp = new HashMap<>();
        for (String key : participant) {
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            mp.put(completion[i], mp.get(completion[i]) - 1);
            if (mp.get(completion[i]) == 0) {
                mp.remove(completion[i]);
            }
        }

        Iterator<String> iterator = mp.keySet().iterator();
        String answer = iterator.next();

        return answer;
    }
}
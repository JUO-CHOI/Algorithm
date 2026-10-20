import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String name;
        
        for (int i = 0; i < participant.length; i++) {
            name = participant[i];
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }
        
        for (int i = 0; i < completion.length; i++) {
            name = completion[i];
            map.put(name, map.get(name) - 1);
            if (map.get(name) == 0) {
                map.remove(name);
            }
        }
        
        return map.keySet().iterator().next();
    }
}
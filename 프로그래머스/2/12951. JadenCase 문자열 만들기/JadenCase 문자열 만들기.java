import java.util.ArrayList;
import java.util.List;

class Solution {
   public static String solution(String s) {

        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        char before = ' ';
        char now = ' ';
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if (before == ' ' && now != ' ') {
                if (!Character.isDigit(now)) {
                    now = Character.toUpperCase(now);
                }
            }
            answer.append(now);
            before = now;
        }

        return answer.toString();
    }
}
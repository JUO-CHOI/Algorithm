import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder str = new StringBuilder();
        Queue<String> codeQ = new LinkedList<>();
        Collections.addAll(codeQ, code.split(""));

        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) str.append(codeQ.poll());
            else codeQ.poll();
        }
        String answer = str.toString();
        return answer;
    }
    
        public String solution_1(int q, int r, String code) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            if (i % q == r)
                str.append(code.charAt(i));
        }
        String answer = str.toString();
        return answer;
    }
}
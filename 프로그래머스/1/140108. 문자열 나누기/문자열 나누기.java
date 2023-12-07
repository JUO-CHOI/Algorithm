import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char compare = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                compare = s.charAt(i);
                count++;
                continue;
            }
            if (compare == s.charAt(i)) {
                stack.push(s.charAt(i));
            }
            else {
                stack.pop();
            }
        }
        return count;
    }
}

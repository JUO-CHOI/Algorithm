class Solution {
    public int solution(String s) {
        char x = s.charAt(0);
        int answer = 0;
        int countX = 0;
        int notCountX = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x == s.charAt(i)) countX++;
            else notCountX++;
            
            if (countX == notCountX) {
                answer++;
                countX = 0;
                notCountX = 0;
                if (i + 1 == s.length()) break;
                x = s.charAt(i+1);
            }
            else if (i + 1 == s.length()) {
                answer++;
            }
        }
        return answer;
    }
}
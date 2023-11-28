class Solution {
    public int solution(String s) {
        char x = s.charAt(0);
        int answer = 1; // 앞 한덩어리 세고 시작
        int countX = 0;
        int notCountX = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x == s.charAt(i)) countX++;
            else notCountX++;
            
            if (countX == notCountX) {
                if (i + 1 == s.length()) break; // 꽉 찼을 때 break, answer을 1부터 셌기 때문에 마지막 덩어리는 어차피 더해져 있음
                answer++;
                countX = 0;
                notCountX = 0;
                x = s.charAt(i+1);
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(String t, String p) {
        // T : t개 / P : p개
        // t를 앞에서부터 p개씩 자른다
        // T는 t - (p - 1) * 2 개의 문자열로 나뉨
        int answer = 0;
        for (int i = 0; i < t.length() - (p.length() - 1); i++) {
            String compare = t.substring(i, i + p.length());
            if (Long.parseLong(compare) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}
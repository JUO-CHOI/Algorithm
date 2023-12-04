class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int sequence = a;
        for (int i = 0; i < included.length; i++) {
            sequence = a + d * (i);
            if (included[i]) {
                answer += sequence;
            }
        }
        return answer;
    }
}
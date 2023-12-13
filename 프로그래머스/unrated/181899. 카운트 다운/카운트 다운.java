class Solution {
    public int[] solution(int start, int end_num) {
        
        int n = start - end_num + 1;
        int[] answer = new int[n];
        int j = 0;
        
        for (int i = start; i > end_num - 1; i--) {
            answer[j] = i;
            j++;
        }
        
        return answer;
    }
}
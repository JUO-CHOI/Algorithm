class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int i = 1;
        int j = 1;

        while (true) {
            while (j <= i) {
                if (
                        (i - 2) * (j - 2) == yellow &&
                                (i + j) * 2 - 4 == brown
                ) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
                j++;
            }
            j = 1;
            i++;
        }
    }
}
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // 총 계산해야 할 배열의 갯수 파악
        int arrayNum = commands.length;

        // 임시로 담을 리스트
        int[] answer = new int[arrayNum];

        for (int i = 0; i < arrayNum; i++) {
            int[] ijk = commands[i];
            int[] tempArr = Arrays.copyOfRange(array, ijk[0] - 1, ijk[1]);
            Arrays.sort(tempArr);
            answer[i] = tempArr[ijk[2] - 1];
        }
        return answer;
    }
}
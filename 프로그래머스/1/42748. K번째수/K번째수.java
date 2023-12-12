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
            int num = tempArr.length;
            for (int j = 0; j < num; j++) {
                int minIndex = j; // 가장 작은 수가 있는 인덱스, 초기에는 맨 앞
                int temp;

                for(int k = j; k < num; k++) {
                    if (tempArr[k] < tempArr[minIndex]) {
                        minIndex = k; // 더 작은 숫자를 가진 인덱스
                    }
                }
                temp = tempArr[j]; // 맨 앞 숫자 temp에 저장
                tempArr[j] = tempArr[minIndex]; // 맨 앞에 가장 작 수 저장
                tempArr[minIndex] = temp; // 빈 자리에 기존 맨 앞 숫자 저장
            }
            System.out.println(Arrays.toString(tempArr));
            answer[i] = tempArr[ijk[2] - 1];
        }
        return answer;
    }
}
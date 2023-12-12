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
                int maxIndex = 0; // 가장 큰 수가 있는 인덱스
                int temp;
                // 배열의 길이만큼 비교, 제일 큰 수를 가장 뒤에 두므로
                // 정렬할때마다 비교하는 횟수가 1씩 줄어듬
                for(int k = 0; k < num - j; k++) {
                    if (tempArr[k] > tempArr[maxIndex]) {
                        maxIndex = k; // 더 큰 숫자를 가진 인덱스
                    }
                }
                temp = tempArr[num - j - 1]; // 맨 뒷 숫자 temp에 저장
                tempArr[num - j - 1] = tempArr[maxIndex]; // 맨 뒤에 가장 큰 수 저장
                tempArr[maxIndex] = temp; // 빈 자리에 기존 맨 뒷 숫자 저장
            }
           
//            Arrays.sort(tempArr);
            answer[i] = tempArr[ijk[2] - 1];
        }

//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
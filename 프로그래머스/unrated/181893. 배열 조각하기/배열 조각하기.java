import java.util.Arrays;

class Solution {

    public int[] solution(int[] arr, int[] query) {
        int left = 0;
        int right = arr.length - 1;

        // 쿼리 순회하기
        for (int i = 0; i < query.length; i++) {
            // 홀짝 구분
            if (i % 2 == 0) {
                // 짝수
                right = left + query[i];
            }
            else {
                // 홀수
                left += query[i];
            }
        }
        return Arrays.copyOfRange(arr, left, right + 1);
    }
}
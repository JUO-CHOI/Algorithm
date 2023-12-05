import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        // 정렬을 하기 위해 배열로 나열한다
        int[] numbers = {a, b, c};
        // 정렬
        Arrays.sort(numbers);

        // 1. 0번과 2번이 동일하면 3개 일치 (두개가 일치하면 가운데는 당연히 같음)
        if (numbers[0] == numbers[2]) {
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        }
        // 2. 0번과 1번이 같거나, 1번과 2번이 같음
        else if (numbers[0] == numbers[1] || numbers[1] == numbers[2]) {
            return (a + b + c) * (a * a + b * b + c * c);
        }
        // 3. 아니면 다 다름
        else {
            return (a + b + c);
        }
    }
}
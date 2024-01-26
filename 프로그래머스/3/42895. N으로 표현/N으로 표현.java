import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(7, 11));
    }

    public static int solution(int N, int number) {
        // 닶이 없다면(for문에서 답을 찾지 못해 대치되지 않으면) -1 반환
        int answer = -1;

        // 각 회차별 결과값을 가질 Set -> 중복 방지
        Set<Integer>[] set = new Set[9];

        // N, NN, NNN 과 같은 수는 사칙연산으로 만들기 어려움 -> 먼저 넣어주고 시작하자
        int inputN = 0;
        for (int i = 1; i < 9; i++) {
            set[i] = new HashSet<>();
            inputN = 10 * inputN + N; // 10 * NN + N -> NNN
            set[i].add(inputN);
        }

        // dp[i]의 값은 j + k = i 인 dp[j]와 dp[k]의 사칙연산으로 만들어진다.
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : set[j]) {
                    for (int num2 : set[i - j]) {
                        set[i].add(num1 + num2);
                        set[i].add(num1 - num2);
                        set[i].add(num1 * num2);
                        if (num2 != 0) {
                            set[i].add(num1 / num2);
                        }
                    }
                }
            }
            if (set[i].contains(number))
                return i;
        }

        return answer;
    }
}
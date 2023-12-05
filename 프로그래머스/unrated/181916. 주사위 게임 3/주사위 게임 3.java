import java.util.Arrays;

class Solution {
public static int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] sortNum = {a, b, c, d};
        Arrays.sort(sortNum);

        // 네개가 같음
        if (sortNum[0] == sortNum[3]) {
            return 1111 * sortNum[0];
        }
        // 세개만 같음
        else if (sortNum[0] == sortNum[2] || sortNum[1] == sortNum[3]) {
            // 앞 세개
            // 이 경우 어차피 [1]과 [2]는 무조건 같음. [0]과 [3]을 더해서 [1]을 빼주면 다른 하나만 남는다.
            return (int) Math.pow(sortNum[1] * 10 + (sortNum[0] + sortNum[3] - sortNum[1]), 2);

        }
        // 두개씩 같음
        else if (sortNum[0] == sortNum[1] && sortNum[2] == sortNum[3]) {
            return (sortNum[0] + sortNum[3]) * (sortNum[3] - sortNum[0]);
        }
        // 앞 두개만 같음 (뒤는 무조건 다름, 왜냐면 앞에서 같은 경우는 걸렀으니까)
        else if (sortNum[0] == sortNum[1]) return sortNum[2] * sortNum[3];
        // 가운데 두개만 같음
        else if (sortNum[1] == sortNum[2]) return sortNum[0] * sortNum[3];
        // 뒤 두개 같음
        else if (sortNum[2] == sortNum[3]) return sortNum[0] * sortNum[1];
        // 네개 다 다름
        else 
            return sortNum[0];
    }
}
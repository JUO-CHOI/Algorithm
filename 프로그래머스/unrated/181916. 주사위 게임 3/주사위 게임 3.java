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
            if (sortNum[0] == sortNum[1]) return (10 * sortNum[0] + sortNum[3]) * (10 * sortNum[0] + sortNum[3]);
            // 뒤 세개
            else return (10 * sortNum[3] + sortNum[0]) * (10 * sortNum[3] + sortNum[0]);
        }
        else if (sortNum[0] == sortNum[1] && sortNum[2] == sortNum[3]) {
            return (sortNum[0] + sortNum[3]) * (sortNum[3] - sortNum[0]);
        }
        // 네개 다 다름
        else if (sortNum[0] != sortNum[1] && sortNum[1] != sortNum[2] && sortNum[2] != sortNum[3])
            return sortNum[0];
        // 두개만 같음
        else {
            // 앞 두개
            if (sortNum[0] == sortNum[1]) return sortNum[2] * sortNum[3];
            // 가운데 두개
            else if (sortNum[1] == sortNum[2]) return sortNum[0] * sortNum[3];
            // 뒤 두개
            else return sortNum[0] * sortNum[1];
        }
    }
}
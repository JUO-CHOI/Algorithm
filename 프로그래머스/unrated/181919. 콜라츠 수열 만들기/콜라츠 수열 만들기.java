import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
public int[] solution(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            count++;
            if (n == 1) {
                sb.append(n);
                break;
            }
            else if (n % 2 == 0) {
                sb.append(n).append(" ");
                n = n / 2;
            }
            else if (n % 2 == 1) {
                sb.append(n).append(" ");
                n = n * 3 + 1;
            }
        }

        int i = 0;
        int[] answer = new int[count];
        StringTokenizer st = new StringTokenizer(sb.toString());

        while (st.hasMoreTokens()) {
            answer[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        return answer;
    }
}
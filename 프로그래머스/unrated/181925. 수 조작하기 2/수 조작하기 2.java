class Solution {
public String solution(int[] numLog) {
        StringBuilder str = new StringBuilder();

        // 0번은 초기값은 계산 전이므로 1번부터 확인
        for (int i = 1; i < numLog.length; i++) {
            int cal = numLog[i] - numLog[i - 1];
            switch (cal) {
                case 1 :
                    str.append("w");
                    break;
                case -1 :
                    str.append("s");
                    break;
                case 10 :
                    str.append("d");
                    break;
                case -10 :
                    str.append("a");
                    break;
            }
        }
        return str.toString();
    }
}
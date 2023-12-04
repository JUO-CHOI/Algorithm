class Solution {
    public String solution(String code) {
        // 답을 만들 스트링빌더
        StringBuilder answer = new StringBuilder();
        // 앞에서부터 한글자씩 읽기
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            // 모드에 따라
            switch (mode) {
                case 0 :
                    if (code.charAt(i) == '1') {
                        mode = 1;
                        break;
                    }
                    if (i % 2 == 0) answer.append(code.charAt(i));
                    break;
                case 1 :
                    if (code.charAt(i) == '1') {
                        mode = 0;
                        break;
                    }
                    if (i % 2 == 1) answer.append(code.charAt(i));
                    break;
            }
        }
     if (answer.toString().isEmpty()) return "EMPTY";
        return answer.toString();
    }
}
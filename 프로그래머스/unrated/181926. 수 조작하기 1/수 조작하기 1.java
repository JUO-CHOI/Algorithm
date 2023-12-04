class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        for (int i = 0; i < control.length(); i++) {
            char controlChar = control.charAt(i);
            switch (controlChar) {
                case 'w' :
                    n++;
                    break;
                case 's' :
                    n--;
                    break;
                case 'd' :
                    n += 10;
                    break;
                case 'a' :
                    n -= 10;
                    break;
            }
        }
        return n;
    }
}
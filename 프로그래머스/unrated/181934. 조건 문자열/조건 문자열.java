class Solution {
    public static int solution(String ineq, String eq, int n, int m) {
        String operator = "" + ineq + eq;
        switch (operator) {
            case ">=" :
                if (n >= m) return 1;
                else return 0;
            case "<=" :
                if (n <= m) return 1;
                else return 0;
            case ">!" :
                if (n > m) return 1;
                else return 0;
            case "<!" :
                if (n < m) return 1;
                else return 0;
        }
        return -1;
    }
}
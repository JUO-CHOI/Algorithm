class Solution {
    public static int solution(int a, int b) {
        StringBuilder A = new StringBuilder().append(a);
        StringBuilder B = new StringBuilder().append(b);
        StringBuilder C = new StringBuilder(A);

        int ab = Integer.parseInt(A.append(B).toString());
        int ba = Integer.parseInt(B.append(C).toString());

        if (ab >= ba) return ab;
        else return ba;
    }
}
class Solution {
        public int solution(int a, int b) {
        String stringAB = String.format("%d%d", a, b);
        int integerAB = Integer.parseInt(stringAB);
        
        if (integerAB >= a * b * 2) return integerAB;
        else return a * b * 2;
    }
}
class Solution {
    
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
    
    
    public static int solution(int n) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (n % i == 1)
                return i;
        }
        return -1;
    }
}
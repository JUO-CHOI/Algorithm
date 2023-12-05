class Solution {
        public int solution(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(number.substring(i, i+1));
        }
        return sum % 9;
    }
}